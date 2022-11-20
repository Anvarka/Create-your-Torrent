package ru.itmo.java.server;

import ru.itmo.java.message.torrent.Constants;
import ru.itmo.java.message.torrent.UploadAnswer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class ClientServer implements Runnable {
    private final ExecutorService readPool = Executors.newCachedThreadPool();
    Logger logger = Logger.getLogger(ClientServer.class.getName());
    ConcurrentHashMap<UploadAnswer, List<Long>>  distributedFiles;
    ServerSocket serverSocket;

    public ClientServer(ConcurrentHashMap<UploadAnswer, List<Long>>  distributedFiles, ServerSocket serverSocket){
        this.distributedFiles = distributedFiles;
        this.serverSocket = serverSocket;
    };

    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("I'm here, client server");
                Socket socket = serverSocket.accept();
                logger.info("Client to connect client server: " + socket.getInetAddress().getHostAddress());
                readPool.submit(new ClientServerWorker(socket, distributedFiles));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        shutdownTracker();
    }

    public void shutdownTracker() {
        readPool.shutdown();
    }
}
