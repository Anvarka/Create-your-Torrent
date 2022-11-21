package ru.itmo.java.server;

import com.google.protobuf.ByteString;
import ru.itmo.java.message.torrent.*;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class ClientServerWorker implements Runnable, AutoCloseable {
    private Socket clientSocket;
    private final Logger logger = Logger.getLogger(ClientServerWorker.class.getName());
    private final ExecutorService writePool = Executors.newSingleThreadExecutor();
    private final ConcurrentHashMap<FileContent, List<Long>> fileAndParts;

    public ClientServerWorker(Socket socket, ConcurrentHashMap<FileContent, List<Long>> distributedFiles) {
        clientSocket = socket;
        this.fileAndParts = distributedFiles;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                RequestToClientServer request = RequestToClientServer
                        .parseDelimitedFrom(clientSocket.getInputStream());

                WriteTask writeTask = switch (request.getRequestCase()) {
                    case STATREQUEST -> handle(request.getStatRequest());
                    case GETREQUEST -> handle(request.getGetRequest());
                    default -> null;
                };
                if (writeTask == null) {
                    logger.info("Error request to client");
                    continue;
                }
                executeWriteTask(writeTask);
            } catch (Exception e) {
                System.out.println("error in request to client");
            }
        }
        try {
            close();
        } catch (Exception e) {
            System.out.println("error in close clientServer");
//            e.printStackTrace();
        }
    }

    private WriteTask handle(StatRequest statRequest) throws IOException {
        logger.info("Get StatRequest");
        var idFile = statRequest.getIdFile();
        // lock.lock;
        // try {
        ConcurrentHashMap<Long, FileContent> idFileAndContent = new ConcurrentHashMap<>();
        for (var fileContent : fileAndParts.keySet()) {
            idFileAndContent.put(fileContent.getIdFile(), fileContent);
        }
        // finally {lock.unlock();}

        UserInfo userInfo = UserInfo.newBuilder()
                .setIp(clientSocket.getInetAddress().getHostAddress())
                .setPort(clientSocket.getPort())
                .build();

        var statAnswer = StatAnswer.newBuilder()
                .setClient(userInfo)
                .setIdFile(idFile)
                .setCountOfAvailableParts(fileAndParts.get(idFileAndContent.get(idFile)).size())
                .addAllPart(fileAndParts.get(idFileAndContent.get(idFile)))
                .build();

        return () -> ResponseFromClientServer.newBuilder()
                .setStatAnswer(statAnswer)
                .build()
                .writeDelimitedTo(clientSocket.getOutputStream());
    }

    private WriteTask handle(GetRequest getRequest) {
        logger.info("Get GetRequest");
        long idFile = getRequest.getIdFile();
        logger.info("Get id:" + idFile);
        long partNumber = getRequest.getPartOfFile();
        logger.info("Get part: " + partNumber);
        ConcurrentHashMap<Long, FileContent> idKeyAndInfo = new ConcurrentHashMap<>();
        for (var fileContent : fileAndParts.keySet()) {
            idKeyAndInfo.put(fileContent.getIdFile(), fileContent);
        }
        logger.info("Get list");

        FileContent fileInfo = idKeyAndInfo.get(idFile);
        logger.info("Get fileInfo");
        FileContent fileContent = FileContent.newBuilder()
                .setSizeFile(fileInfo.getSizeFile())
                .setIdFile(fileInfo.getIdFile())
                .setFilename(fileInfo.getFilename())
                .build();
        byte[] contentOfPart = FileSplitter.getContentFromPart(fileInfo, partNumber);

        var getAnswer = GetAnswer.newBuilder()
                .setContent(ByteString.copyFrom(contentOfPart))
                .setFileContent(fileContent)
                .setPartOfFile(partNumber)
                .build();
        return () -> ResponseFromClientServer.newBuilder()
                .setGetAnswer(getAnswer)
                .build()
                .writeDelimitedTo(clientSocket.getOutputStream());
    }


    private void executeWriteTask(WriteTask task) {
        writePool.submit(() -> {
            try {
                task.run();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void close() throws Exception {
        writePool.shutdown();
    }
}
