package ru.itmo.java.reminder;

import ru.itmo.java.client.Client;
import ru.itmo.java.info.ClientInformer;
import ru.itmo.java.message.torrent.Constants;
import ru.itmo.java.message.torrent.RequestToTracker;
import ru.itmo.java.message.torrent.UpdateRequest;
import ru.itmo.java.message.torrent.UserInfo;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

/**
 * Thread reminds the server of itself for some time (300 mills)
 */
public class ReminderToServer implements Runnable {
    private final Logger logger = Logger.getLogger(ReminderToServer.class.getName());
    private final Socket trackerSocket;
    private final ServerSocket serverSocket;
    private final Client client;
    private final ClientInformer clientInformer;
    public ReminderToServer(Socket trackerSocket, ServerSocket serverSocket, Client client, ClientInformer clientInformer){
        this.trackerSocket = trackerSocket;
        this.serverSocket = serverSocket;
        this.client = client;
        this.clientInformer = clientInformer;
    }
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
               client.executeWriteTask(() -> {
                    RequestToTracker.newBuilder().setUpdate(updateRequest).build().writeDelimitedTo(trackerSocket.getOutputStream());
                    client.executeReadTask(client.handlerResponseFromTracker::handleResponseFromTracker);
                });
                Thread.sleep(Constants.UPDATE_TIME_SLEEP);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}