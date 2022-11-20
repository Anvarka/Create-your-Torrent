//package ru.itmo.java.client;
//
//import ru.itmo.java.message.torrent.*;
//
//import java.io.File;
//import java.io.IOException;
//import java.net.Socket;
//import java.util.List;
//
//import static ru.itmo.java.message.torrent.Constants.*;
//
//public class Messenger {
//
//    public static void sendMessageToTracker(Socket socket, String command, String[] args) {
//        try {
//            switch (command) {
//                case LIST -> sendList();
//                case UPLOAD -> sendUpload(args);
//                case SOURCES -> sendSource(args);
////                case STAT -> sendStat(args);
////                case DOWNLOAD -> messageSenderToClientFromClient.download2(args);
//                default -> System.out.println("Incorrect command\n" + RULE);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static Object getMessageFromTracker() throws IOException {
//        BaseResponse response = BaseResponse.parseDelimitedFrom(socketWithServer.getInputStream());
//        Object res = null;
//        try {
//            switch (response.getResponseCase()) {
//                case LISTANSWER -> executeListAnswer(response);
//                case UPLOADANSWER -> executeUploadAnswer(response);
//                case SOURCESANSWER -> res = executeSourceAnswer(response);
//                case UPDATEANSWER -> executeUpdateAnswer(response);
//                default -> System.out.println("Invalid response");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return res;
//    }
//
//    public static void createRequest() throws IOException {
//        ListRequest listRequest = ListRequest.newBuilder().build();
//        // отправка на сервак запроса
//        BaseRequest.newBuilder().setListRequest(listRequest).build().writeDelimitedTo(serverSocket.getOutputStream());
//        getMessageFromTracker();
//
//    }
//
//    public static synchronized void sendList() throws IOException {
//        ListRequest listRequest = ListRequest.newBuilder().build();
//        // отправка на сервак запроса
////        var r = BaseRequest.newBuilder().setListRequest(listRequest).build();
////                .writeDelimitedTo(serverSocket.getOutputStream());
//        getMessageFromTracker();
//
//    }
//
//    public static void createRequest(String command) {
//        var request = switch (command) {
//            case LIST -> ListRequest.newBuilder().build();
////            case UPLOAD -> {
////                System.out.println("sdas");
////                sendUpload(args);
////            }
////            case SOURCES -> sendSource(args);
////            default -> System.out.println("Incorrect command\n" + RULE);
//        };
//    }
//
//    public static synchronized void sendUpload(String[] args) throws IOException {
//        try {
//            String filename = args[1];
//            File file = new File(filename);
//            if (!file.exists() || !file.isFile()) {
//                System.out.println("error file");
//                return;
//            }
//            Upload uploadRequest = Upload.newBuilder().setFilename(filename).setSize(file.length()).build();
//            executeWriteTask(() -> {
//                BaseRequest.newBuilder().setUpload(uploadRequest).build().writeDelimitedTo(serverSocket.getOutputStream());
//                executeReadTask(messageGetter::getMessageFromTracker);
//            });
//        } catch (Exception e) {
//            throw new IOException(e.getCause());
//        }
//    }
//
//    public static synchronized void sendUpdate() throws IOException {
//        Update updateRequest = Update.newBuilder().setClientPort(clientPort)
//                .addAllFileId(keeperInfoAboutClient.getFileIds())
//                .setCountSharedFiles(keeperInfoAboutClient.getFileIds().size())
//                .build();
//        executeWriteTask(() -> {
//            BaseRequest.newBuilder().setUpdate(updateRequest).build().writeDelimitedTo(serverSocket.getOutputStream());
//            executeReadTask(messageGetter::handleResponse);
//        });
//    }
//
//    public static synchronized List<ClientIpAndPort> sendSource(String[] args) throws IOException {
//        try {
//            System.out.println("sendSources");
//            long idFile = Long.parseLong(args[1]);
//            Sources sourceRequest = Sources.newBuilder().setIdFile(idFile).build();
//            BaseRequest.newBuilder().setSources(sourceRequest).build().writeDelimitedTo(serverSocket.getOutputStream());
//            return (List<ClientIpAndPort>) messageGetter.handleResponse();
//        } catch (Exception e) {
//            throw new IOException(e.getCause());
//        }
//    }
//
//    private void executeWriteTask(WriteTask task) {
//        writePool.submit(() -> {
//            try {
//                task.run();
//            } catch (IOException e) {
//                return;
//            }
//        });
//    }
//
//    private void executeReadTask(WriteTask task) {
//        readPool.submit(() -> {
//            try {
//                task.run();
//            } catch (IOException e) {
//            }
//        });
//    }
//
//    public static void executeListAnswer(BaseResponse response) {
//        ListAnswer listAnswer = response.getListAnswer();
//        List<FileContent> files = listAnswer.getFileContentList();
//
//        for (FileContent el : files) {
//            keeperInfoAboutClient.addFileInfo(el.getIdFile(), el.getSizeFile(), el.getFilename());
//            System.out.printf("idFile: %s, filename: %s, size: %s%n",
//                    el.getIdFile(), el.getFilename(), el.getSizeFile());
//        }
//    }
//
//    public static void executeUploadAnswer(BaseResponse response) {
//        UploadAnswer uploadAnswer = response.getUploadAnswer();
//        long idFile = uploadAnswer.getIdFile();
//        String filename = uploadAnswer.getFilename();
//        long size = uploadAnswer.getSize();
//
//        FileInfo fileInfo = new FileInfo(size, filename, idFile);
//        keeperInfoAboutClient.addNewFile(fileInfo);
//        System.out.println("OK!");
//    }
//
//    public static List<ClientIpAndPort> executeSourceAnswer(BaseResponse response) throws IOException {
//        SourcesAnswer sourcesAnswer = response.getSourcesAnswer();
//        long countOfClients = sourcesAnswer.getSizeRes();
//        long idFile = sourcesAnswer.getIdFile();
//        List<ClientIpAndPort> clientsWithNeedFile = sourcesAnswer.getClientWithFileList();
//        System.out.printf("I find %s clients with fileId:%n", countOfClients);
//        for (ClientIpAndPort clientIpAndPort : clientsWithNeedFile) {
//            System.out.printf("ip: %s, port: %s%n",
//                    clientIpAndPort.getIp(), clientIpAndPort.getPort());
////            if (!keeperInfoAboutClient.getIdFileClientInfo().containsKey(idFile)) {
////                Set<ClientInfo> hashSet = new HashSet<>();
////                keeperInfoAboutClient.getIdFileClientInfo().put(idFile, hashSet);
////            }
////            keeperInfoAboutClient.getIdFileClientInfo().get(idFile).add(new ClientInfo(clientIpAndPort.getIp(),
////                    clientIpAndPort.getPort()));
//        }
//        return clientsWithNeedFile;
//    }
//
//    public static void executeUpdateAnswer(BaseResponse response) {
//        UpdateAnswer updateAnswer = response.getUpdateAnswer();
//        boolean status = updateAnswer.getStatusUpdate();
//        if (!status) {
//            System.out.println("Update error");
//        }
//    }
//
//    public void shutdownThreads() {
//        readPool.shutdown();
//        writePool.shutdown();
//    }
//}
