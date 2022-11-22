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
    public final ServerSocket serverSocket = new ServerSocket(Constants.CLIENT_SERVER_PORT);

    private final Thread reminder = new Thread(new ReminderToServer());
    public final ClientInformer clientInformer = new ClientInformer();
    private final Thread clientServer = new Thread(new ClientServer(clientInformer, serverSocket));


    public Client(Socket socket, Scanner scanner) throws IOException {
        logger.info("Client init");
        this.trackerSocket = socket;
        this.scanner = scanner;
        clientInformer.getStateFromFile();

        reminder.start();
        clientServer.start();
    }

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(HOST, TRACKER_PORT);
            Scanner scanner = new Scanner(System.in);
            var client = new Client(socket, scanner);
            client.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (scanner.hasNextLine() && !Thread.interrupted()) {
            String commandStr = scanner.nextLine();
            String[] commandSplit = commandStr.split(" ");
            String command = commandSplit[0];
            clientInterface(trackerSocket, command, commandSplit);
        }
        close();
    }

    public void clientInterface(Socket socket, String command, String[] args) {
        RequestToTracker request = switch (command) {
            case LIST -> RequestCreator.createListRequest();
            case UPLOAD -> RequestCreator.createUploadRequest(args);
            case SETUP -> RequestCreator.createSetupRequest(args);
            default -> null;
        };
        if (request == null) {
            logger.warning("No correct request or not exist upload file");
            return;
        }
        executeWriteTask(() -> {
                    request.writeDelimitedTo(socket.getOutputStream());
                    executeReadTask(this::handleResponseFromTracker);
                }
        );
        logger.info("Request send");
    }

    public void handleResponseFromTracker() throws IOException {
        var response = ResponseFromTracker.parseDelimitedFrom(trackerSocket.getInputStream());
        switch (response.getResponseCase()) {
            case LISTANSWER -> {
                logger.info("Get List answer from tracker");
                var listAnswer = response.getListAnswer();
                List<FileContent> files = listAnswer.getFileContentList();

                for (FileContent el : files) {
                    System.out.printf("idFile: %s, filename: %s, size: %s%n",
                            el.getIdFile(), el.getFilename(), el.getSizeFile());
                }
            }
            case UPLOADANSWER -> {
                logger.info("Get Upload answer from tracker");
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
                logger.info("Get Source answer from tracker");
                var sourcesAnswer = response.getSourcesAnswer();
                long idFIle = sourcesAnswer.getIdFile();
                List<UserInfo> users = sourcesAnswer.getClientWithFileList();
                for (var user : users) {
                    Socket socket = new Socket(user.getIp(), user.getPort());
                    StatRequest statRequest = StatRequest.newBuilder()
                            .setIdFile(idFIle)
                            .build();
                    executeWriteTask(() -> {
                        RequestToClientServer.newBuilder().setStatRequest(statRequest).build().writeDelimitedTo(socket.getOutputStream());
                        executeReadTask(() -> handleResponseFromClientServer(socket));
                    });
                }
            }
            default -> System.out.println("I don't understand response from track");
        }
    }

    public void handleResponseFromClientServer(Socket socket) throws IOException {
        ResponseFromClientServer response = ResponseFromClientServer.parseDelimitedFrom(socket.getInputStream());
        switch (response.getResponseCase()) {
            case STATANSWER -> {
                logger.info("Get Stat answer from clientServer");
                StatAnswer statAnswer = response.getStatAnswer();
                Long idFile = statAnswer.getIdFile();
                List<Long> parts = statAnswer.getPartList();
                clientInformer.addHowCLientWithPart(parts, socket);
                imposter(idFile);
            }
            case GETANSWER -> {
                logger.info("Get Get answer from clientServer");
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
            default -> logger.warning("Error in response of clientServer");

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
            clientInformer.writeStateToFile();
            readPool.shutdown();
            writePool.shutdown();
            reminder.interrupt();
            clientServer.interrupt();
            trackerSocket.close();
        } catch (IOException e) {
            logger.warning("Error in close");
        }
    }

    /**
     * Thread reminds the server of itself for some time (300 mills)
     */
    private class ReminderToServer implements Runnable {
        @Override
        public void run() {
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
