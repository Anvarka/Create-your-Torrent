package ru.itmo.java.client;

import ru.itmo.java.info.ClientInformer;
import ru.itmo.java.message.torrent.*;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.logging.Logger;

public class HandlerResponseFromTracker {
    private final Logger logger = Logger.getLogger(HandlerResponseFromTracker.class.getName());
    private final Socket trackerSocket;
    private final ClientInformer clientInformer;
    private final Client client;
    private final HandlerResponseFromClientServer handlerResponseFromClientServer;


    public HandlerResponseFromTracker(Socket trackerSocket,
                                      Client client,
                                      ClientInformer clientInformer,
                                      HandlerResponseFromClientServer handlerResponseFromClientServer){
        this.trackerSocket = trackerSocket;
        this.clientInformer = clientInformer;
        this.client = client;
        this.handlerResponseFromClientServer = handlerResponseFromClientServer;
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
                    client.executeWriteTask(() -> {
                        RequestToClientServer.newBuilder()
                                .setStatRequest(statRequest)
                                .build()
                                .writeDelimitedTo(socket.getOutputStream());
                        client.executeReadTask(() -> handlerResponseFromClientServer.handleResponseFromClientServer(socket));
                    });
                }
            }
            default -> logger.warning("Client: I don't understand response from tracker");
        }
    }
}
