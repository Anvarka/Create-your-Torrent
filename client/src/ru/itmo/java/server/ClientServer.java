package ru.itmo.java.server;

import ru.itmo.java.info.ClientInformer;
import ru.itmo.java.message.torrent.FileContent;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class ClientServer implements Runnable, AutoCloseable {
    private final ExecutorService readPool = Executors.newCachedThreadPool();
    Logger logger = Logger.getLogger(ClientServer.class.getName());
    ServerSocket serverSocket;
    private final ClientInformer clientInformer;

    public ClientServer(ClientInformer clientInformer, ServerSocket serverSocket){
        this.serverSocket = serverSocket;
        this.clientInformer = clientInformer;
    };

    public void run() {
        try {
            logger.info("clientServer thread activate");
            while (!Thread.interrupted()) {
                Socket socket = serverSocket.accept();
                logger.info("Client to connect client server: " + socket.getInetAddress().getHostAddress());
                readPool.submit(new ClientServerWorker(socket, clientInformer));
            }
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        readPool.shutdown();
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
