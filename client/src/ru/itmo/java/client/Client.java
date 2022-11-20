package ru.itmo.java.client;


import ru.itmo.java.message.torrent.*;
import ru.itmo.java.server.ClientServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

import static ru.itmo.java.message.torrent.Constants.*;


public class Client implements AutoCloseable {
    private final Socket trackerSocket;
    private final Scanner scanner;
    private final ConcurrentHashMap<UploadAnswer, List<Long>> shareFileAndParts = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Socket, List<Long>> userSocketAndParts = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Long, List<Socket>> partAndUserSockets = new ConcurrentHashMap<>();
    private final ExecutorService readPool = Executors.newSingleThreadExecutor();
    private final ExecutorService writePool = Executors.newSingleThreadExecutor();
    private final Logger logger = Logger.getLogger(Client.class.getName());
    private final ServerSocket serverSocket = new ServerSocket(Constants.CLIENT_SERVER_PORT);

    private final Thread reminder = new Thread(new ReminderToServer());
    private final Thread clientServer = new Thread(new ClientServer(shareFileAndParts, serverSocket));


    public Client(Socket socket, Scanner scanner) throws IOException {
        this.trackerSocket = socket;
        this.scanner = scanner;
        logger.info("client init");
        getStateFromFile();

        reminder.start();
        clientServer.start();
    }

    public void getStateFromFile() throws FileNotFoundException {
//        TODO: разные пути для разных клиентов
        File file = new File(Constants.CLIENT_STATE_PATH);
        if (file.exists() && file.isFile()) {
            DataInputStream in = new DataInputStream(new FileInputStream(file));
            try {
                int count = in.readInt();
                for (int i = 0; i < count; i++) {
                    UploadAnswer uploadAnswer = UploadAnswer.newBuilder()
                            .setIdFile(in.readLong())
                            .setFilename(in.readUTF())
                            .setSize(in.readLong())
                            .build();
                    // TODO: clientInformer.addSharedFiles(uploadAnswer);
                    shareFileAndParts.put(uploadAnswer, FileSplitter.getParts(uploadAnswer.getSize()));
                }
            } catch (IOException ignored) {
                System.out.println("no data");
            }
        }
    }

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", TRACKER_PORT);
            Scanner scanner = new Scanner(System.in);
            var client = new Client(socket, scanner);
            client.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() throws IOException {
        while (scanner.hasNextLine() && !Thread.interrupted()) {
            String s = scanner.nextLine();
            String[] s1 = s.split(" ");
            String command = s1[0];
            clientInterface(trackerSocket, command, s1);
        }
        close();
    }

    public void clientInterface(Socket socket, String command, String[] args) {
        RequestToTracker request = null;
        switch (command) {
            case LIST -> {
                var listRequest = ListRequest.newBuilder().build();
                request = RequestToTracker.newBuilder().setListRequest(listRequest).build();
            }
            case UPLOAD -> {
                String filename = args[1];
                File file = new File(filename);
                if (!file.exists() || !file.isFile()) {
                    System.out.println("error file");
                    return;
                }
                UploadRequest uploadRequest = UploadRequest.newBuilder().setFilename(filename).setSize(file.length()).build();
                request = RequestToTracker.newBuilder().setUpload(uploadRequest).build();
            }
            case SETUP -> {
                int idFile = Integer.parseInt(args[1]);
                SourcesRequest sourcesRequest = SourcesRequest.newBuilder()
                        .setIdFile(idFile)
                        .build();

                RequestToTracker finalRequest = RequestToTracker.newBuilder().setSources(sourcesRequest).build();
                executeWriteTask(() -> {
                    finalRequest.writeDelimitedTo(socket.getOutputStream());
                    executeReadTask(this::handleResponseFromTracker);
                });
            }
            default -> request = null;
        }
        if (request == null) {
            System.out.println("No correct request");
            return;
        }
        RequestToTracker finalRequest1 = request;
        executeWriteTask(() -> {
                    finalRequest1.writeDelimitedTo(socket.getOutputStream());
                    executeReadTask(this::handleResponseFromTracker);
                }
        );
    }

    public void handleResponseFromTracker() throws IOException {
        ResponseFromTracker response = ResponseFromTracker.parseDelimitedFrom(trackerSocket.getInputStream());
        switch (response.getResponseCase()) {
            case LISTANSWER -> {
                logger.info("Get List answer from tracker");
                ListAnswer listAnswer = response.getListAnswer();
                List<FileContent> files = listAnswer.getFileContentList();

                for (FileContent el : files) {
                    System.out.printf("idFile: %s, filename: %s, size: %s%n",
                            el.getIdFile(), el.getFilename(), el.getSizeFile());
                }
            }
            case UPLOADANSWER -> {
                logger.info("Get Upload answer from tracker");
                UploadAnswer uploadAnswer = response.getUploadAnswer();
                // TODO: clientInformer.addSharedFiles(uploadAnswer);
                shareFileAndParts.put(uploadAnswer, FileSplitter.getParts(uploadAnswer.getSize()));
            }
            case UPDATEANSWER -> {
                UpdateAnswer updateAnswer = response.getUpdateAnswer();
            }
            case SOURCESANSWER -> {
                logger.info("Get Source answer from tracker");
                SourcesAnswer sourcesAnswer = response.getSourcesAnswer();
                long idFIle = sourcesAnswer.getIdFile();
                System.out.println(idFIle);
                List<UserInfo> users = sourcesAnswer.getClientWithFileList();
                // TODO: пользователи у кого есть какой-то кусок
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
            default -> System.out.println("I don't understand response");
        }
    }

    public void handleResponseFromClientServer(Socket socket) throws IOException {
        ResponseFromClientServer response = ResponseFromClientServer.parseDelimitedFrom(socket.getInputStream());
        switch (response.getResponseCase()) {
            case STATANSWER -> {
                logger.info("Get Stat answer from clientServer");
                StatAnswer statAnswer = response.getStatAnswer();
//                UserInfo userInfo = statAnswer.getClient();
                Long idFile = statAnswer.getIdFile();
                List<Long> parts = statAnswer.getPartList();
                userSocketAndParts.put(socket, parts);
                for (Long part : parts) {
                    if (!partAndUserSockets.contains(part)) {
                        partAndUserSockets.put(part, new ArrayList<>());
                    }
                    partAndUserSockets.get(part).add(socket);
                }
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
                    System.out.println("Write part this file!");
                    UploadAnswer uploadAnswer = UploadAnswer.newBuilder()
                            .setFilename(fileContent.getFilename())
                            .setIdFile(fileContent.getIdFile())
                            .setSize(fileContent.getSizeFile())
                            .build();
                    if (shareFileAndParts.contains(uploadAnswer)) {
                        shareFileAndParts.put(uploadAnswer, new ArrayList<>());
                    }
                    shareFileAndParts.get(uploadAnswer).add(part);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            default -> {
                System.out.println("Error in response of clientServer");
            }
        }
    }

    private void imposter(Long idFile) {
        java.util.Random random = new java.util.Random();

        for (Map.Entry<Long, List<Socket>> partAndSockets : partAndUserSockets.entrySet()) {
            long partId = partAndSockets.getKey();
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


    private void executeWriteTask(WriteTask task) {
        writePool.submit(() -> {
            try {
                task.run();
            } catch (IOException ignored) {
            }
        });
    }

    private void executeReadTask(WriteTask task) {
        readPool.submit(() -> {
            try {
                task.run();
            } catch (IOException ignored) {
            }
        });
    }

    @Override
    public void close() throws IOException {
        DataOutputStream out = new DataOutputStream(new FileOutputStream(Constants.CLIENT_STATE_PATH));
        out.writeInt(shareFileAndParts.size());
        System.out.println("We are close");
        for (var l : shareFileAndParts.entrySet()) {
            out.writeLong(l.getKey().getIdFile());
            out.writeUTF(l.getKey().getFilename());
            out.writeLong(l.getKey().getSize());
        }
        readPool.shutdown();
        writePool.shutdown();
        trackerSocket.close();
        reminder.interrupt();
        clientServer.interrupt();
        out.close();
    }

    /**
     * Thread reminds the server of itself for some time (300 mills)
     */
    private class ReminderToServer implements Runnable {
        @Override
        public void run() {
            while (!Thread.interrupted()) {
                try {
                    int countFiles = shareFileAndParts.size();

                    UserInfo userInfo = UserInfo.newBuilder()
                            .setIp(trackerSocket.getRemoteSocketAddress().toString())
                            .setPort(serverSocket.getLocalPort())
                            .build();

                    // TODO: clientInformer.addSharedFiles(uploadAnswer);
                    UpdateRequest updateRequest = UpdateRequest.newBuilder()
                            .setUserInfo(userInfo)
                            .setPortOfClientServer(serverSocket.getLocalPort())
                            .setCountSharedFiles(countFiles)
                            .addAllUploadAnswer(shareFileAndParts.keySet())
                            .build();
                    executeWriteTask(() -> {
                        RequestToTracker.newBuilder().setUpdate(updateRequest).build().writeDelimitedTo(trackerSocket.getOutputStream());
                        executeReadTask(this::handleResponse);
                    });
                    Thread.sleep(Constants.UPDATE_TIME_SLEEP);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }

        private void handleResponse() throws IOException {
            ResponseFromTracker response = ResponseFromTracker.parseDelimitedFrom(trackerSocket.getInputStream());
            switch (response.getResponseCase()) {
                case LISTANSWER -> {
                    ListAnswer listAnswer = response.getListAnswer();
                    List<FileContent> files = listAnswer.getFileContentList();

                    for (FileContent el : files) {
                        System.out.printf("idFile: %s, filename: %s, size: %s%n",
                                el.getIdFile(), el.getFilename(), el.getSizeFile());
                    }
                }
                case UPLOADANSWER -> {
                    UploadAnswer uploadAnswer = response.getUploadAnswer();
                    // TODO: clientInformer.addSharedFiles(uploadAnswer);
                    shareFileAndParts.put(uploadAnswer, FileSplitter.getParts(uploadAnswer.getSize()));
                }
                case UPDATEANSWER -> {
                    UpdateAnswer updateAnswer = response.getUpdateAnswer();
                }
                default -> System.out.println("I don't understand response");
            }
        }
    }

}
