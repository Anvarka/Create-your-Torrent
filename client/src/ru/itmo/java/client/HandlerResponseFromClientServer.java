package ru.itmo.java.client;

import ru.itmo.java.info.ClientInformer;
import ru.itmo.java.message.torrent.*;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class HandlerResponseFromClientServer {
    private final Logger logger = Logger.getLogger(HandlerResponseFromClientServer.class.getName());
    private final ClientInformer clientInformer;
    private final Client client;

    public HandlerResponseFromClientServer(Client client, ClientInformer clientInformer){
        this.clientInformer = clientInformer;
        this.client = client;
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
            client.executeWriteTask(() -> {
                RequestToClientServer.newBuilder().setGetRequest(getRequest).build().writeDelimitedTo(socket.getOutputStream());
                client.executeReadTask(() -> handleResponseFromClientServer(socket));
            });
        }
    }
}
