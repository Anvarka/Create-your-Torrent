package ru.itmo.java.client;


import ru.itmo.java.info.ClientInformer;
import ru.itmo.java.message.torrent.*;
import ru.itmo.java.server.ClientServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

import static ru.itmo.java.message.torrent.Constants.*;


public class Client implements AutoCloseable {
    public final Socket trackerSocket;
    private final Scanner scanner;

    private final ExecutorService readPool = Executors.newSingleThreadExecutor();
    private final ExecutorService writePool = Executors.newSingleThreadExecutor();
    private final Logger logger = Logger.getLogger(Client.class.getName());
    public final ServerSocket serverSocket;

    private final Thread reminder = new Thread(new ReminderToServer());
    public final ClientInformer clientInformer = new ClientInformer();
    private final Thread clientServer;

    private final RequestCreator requestCreator = new RequestCreator();


    public Client(Socket socket, Scanner scanner, int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
        logger.info("client init");
        this.trackerSocket = socket;
        this.scanner = scanner;
        clientInformer.getStateFromFile();
        reminder.start();
        clientServer = new Thread(new ClientServer(clientInformer, serverSocket));
        clientServer.start();
    }

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(HOST, TRACKER_PORT);
            Scanner scanner = new Scanner(System.in);
            int port = Integer.parseInt(args[0]);
            var client = new Client(socket, scanner, port);
            registerShutdownHook(client);
            client.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (scanner.hasNextLine() && !Thread.interrupted() && !trackerSocket.isClosed()) {
            try {
                String commandStr = scanner.nextLine();
                String[] commandSplit = commandStr.split(" ");
                String command = commandSplit[0];
                clientInterface(trackerSocket, command, commandSplit);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        close();
    }

    private static void registerShutdownHook(Client client) {
        Runtime.getRuntime().addShutdownHook(new Thread(client::close));
    }

    public void clientInterface(Socket socket, String command, String[] args) {
        RequestToTracker request = switch (command) {
            case LIST_CMD -> requestCreator.createListRequest();
            case UPLOAD_CMD -> requestCreator.createUploadRequest(args);
            case DOWNLOAD_CMD -> requestCreator.createDownloadRequest(args);
            default -> null;
        };
        if (request == null) {
            logger.warning(String.format("No correct request for command: %s", command));
            logger.info(CLIENT_RULE);
            return;
        }
        executeWriteTask(() -> {
                    request.writeDelimitedTo(socket.getOutputStream());
                    executeReadTask(this::handleResponseFromTracker);
                }
        );
        logger.info("Client: request send");
    }

    public void handleResponseFromTracker() throws IOException {
        var response = ResponseFromTracker.parseDelimitedFrom(trackerSocket.getInputStream());
        switch (response.getResponseCase()) {
            case LISTANSWER -> {
                logger.info("Client: get ListAnswer from tracker");
                var listAnswer = response.getListAnswer();
                List<FileContent> files = listAnswer.getFileContentList();

                for (FileContent el : files) {
                    System.out.printf("idFile: %s, filename: %s, size: %s%n",
                            el.getIdFile(), el.getFilename(), el.getSizeFile());
                }
            }
            case UPLOADANSWER -> {
                logger.info("Client: get UploadAnswer from tracker");
                var uploadAnswer = response.getUploadAnswer();
                clientInformer.addSharedFiles(
                        uploadAnswer.getFileContent(),
                        FileSplitter.getParts(uploadAnswer.getFileContent().getSizeFile())
                );
            }
            case UPDATEANSWER -> {
                UpdateAnswer updateAnswer = response.getUpdateAnswer();
            }
            case SOURCESANSWER -> {
                logger.info("Client: get SourceAnswer from tracker");
                var sourcesAnswer = response.getSourcesAnswer();
                long idFIle = sourcesAnswer.getIdFile();
                List<UserInfo> users = sourcesAnswer.getClientWithFileList();
                for (var user : users) {
                    Socket socket = new Socket(user.getIp(), user.getPort());
                    StatRequest statRequest = StatRequest.newBuilder()
                            .setIdFile(idFIle)
                            .build();
                    executeWriteTask(() -> {
                        RequestToClientServer.newBuilder()
                                .setStatRequest(statRequest)
                                .build()
                                .writeDelimitedTo(socket.getOutputStream());
                        executeReadTask(() -> handleResponseFromClientServer(socket));
                    });
                }
            }
            default -> logger.warning("Client: I don't understand response from tracker");
        }
    }

    public void handleResponseFromClientServer(Socket socket) throws IOException {
        ResponseFromClientServer response = ResponseFromClientServer.parseDelimitedFrom(socket.getInputStream());
        switch (response.getResponseCase()) {
            case STATANSWER -> {
                logger.info("Client: get StatAnswer from clientServer");
                StatAnswer statAnswer = response.getStatAnswer();
                Long idFile = statAnswer.getIdFile();
                List<Long> parts = statAnswer.getPartList();
                clientInformer.addHowCLientWithPart(parts, socket);
                imposter(idFile);
            }
            case GETANSWER -> {
                logger.info("Client: get GetAnswer from clientServer");
                GetAnswer getAnswer = response.getGetAnswer();
                byte[] content = getAnswer.getContent().toByteArray();
                FileContent fileContent = getAnswer.getFileContent();
                long part = getAnswer.getPartOfFile();
                try {
                    FileSplitter.writeContentToPartOfFile(fileContent, part, content);
                    logger.info("Write part this file!");
                    clientInformer.addSharedFile(fileContent, part);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            default -> logger.warning("Client: I don't understand response from clientServer");
        }
    }

    private void imposter(Long idFile) {
        java.util.Random random = new java.util.Random();

        for (Map.Entry<Long, List<Socket>> partAndSockets : clientInformer.getPartAndUserSockets().entrySet()) {
            long partId = partAndSockets.getKey();
            if (partAndSockets.getValue().size() == 0) {
                logger.warning("No clients with this part");
                continue;
            }
            int numberRandomSocket = random.nextInt(partAndSockets.getValue().size());
            Socket socket = partAndSockets.getValue().get(numberRandomSocket);
            GetRequest getRequest = GetRequest.newBuilder()
                    .setIdFile(idFile)
                    .setPartOfFile(partId)
                    .build();
            executeWriteTask(() -> {
                RequestToClientServer.newBuilder().setGetRequest(getRequest).build().writeDelimitedTo(socket.getOutputStream());
                executeReadTask(() -> handleResponseFromClientServer(socket));
            });
        }
    }


    public void executeWriteTask(WriteTask task) {
        writePool.submit(() -> {
            try {
                task.run();
            } catch (IOException ignored) {
            }
        });
    }

    public void executeReadTask(WriteTask task) {
        readPool.submit(() -> {
            try {
                task.run();
            } catch (IOException ignored) {
            }
        });
    }

    @Override
    public void close() {
        try {
            logger.info("In client close");
            trackerSocket.close();
            readPool.shutdown();
            writePool.shutdown();
            reminder.interrupt();
            clientServer.interrupt();
            clientInformer.close();
        } catch (IOException e) {
            logger.warning("Error in close");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Thread reminds the server of itself for some time (300 mills)
     */
    private class ReminderToServer implements Runnable {
        @Override
        public void run() {
            logger.info("reminder thread activate");
            while (!Thread.interrupted()) {
                try {
                    UserInfo userInfo = UserInfo.newBuilder()
                            .setIp(trackerSocket.getRemoteSocketAddress().toString())
                            .setPort(serverSocket.getLocalPort())
                            .build();

                    UpdateRequest updateRequest = UpdateRequest.newBuilder()
                            .setUserInfo(userInfo)
                            .setPortOfClientServer(serverSocket.getLocalPort())
                            .addAllFileContent(clientInformer.getAllSharedFiles())
                            .build();
                    executeWriteTask(() -> {
                        RequestToTracker.newBuilder().setUpdate(updateRequest).build().writeDelimitedTo(trackerSocket.getOutputStream());
                        executeReadTask(Client.this::handleResponseFromTracker);
                    });
                    Thread.sleep(Constants.UPDATE_TIME_SLEEP);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
}
