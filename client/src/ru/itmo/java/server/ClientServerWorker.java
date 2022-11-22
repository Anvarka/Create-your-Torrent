package ru.itmo.java.server;

import com.google.protobuf.ByteString;
import ru.itmo.java.info.ClientInformer;
import ru.itmo.java.message.torrent.*;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class ClientServerWorker implements Runnable, AutoCloseable {
    private final Socket clientSocket;
    private final Logger logger = Logger.getLogger(ClientServerWorker.class.getName());
    private final ExecutorService writePool = Executors.newSingleThreadExecutor();
    private final ClientInformer clientInformer;

    public ClientServerWorker(Socket socket, ClientInformer clientInformer) {
        clientSocket = socket;
        this.clientInformer  = clientInformer;
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
                    logger.warning("Error request to client");
                    continue;
                }
                executeWriteTask(writeTask);
            } catch (Exception e) {
                logger.warning("Error in getting request to client");
            }
        }
        close();
    }

    private WriteTask handle(StatRequest statRequest) {
        logger.info("Get StatRequest");
        var idFile = statRequest.getIdFile();

        UserInfo userInfo = UserInfo.newBuilder()
                .setIp(clientSocket.getInetAddress().getHostAddress())
                .setPort(clientSocket.getPort())
                .build();

        var statAnswer = StatAnswer.newBuilder()
                .setClient(userInfo)
                .setIdFile(idFile)
                .addAllPart(clientInformer.getPartsOfFile(idFile))
                .build();

        return () -> ResponseFromClientServer.newBuilder()
                .setStatAnswer(statAnswer)
                .build()
                .writeDelimitedTo(clientSocket.getOutputStream());
    }

    private WriteTask handle(GetRequest getRequest) {
        logger.info("Get GetRequest");
        long idFile = getRequest.getIdFile();
        long partNumber = getRequest.getPartOfFile();

        FileContent fileContent = clientInformer.getContentOfFile(idFile);
        logger.info("Get fileInfo");
        byte[] contentOfPart = FileSplitter.getContentFromPart(fileContent, partNumber);

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
    public void close() {
        writePool.shutdown();
    }
}
