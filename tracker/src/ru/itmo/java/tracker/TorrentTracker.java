package ru.itmo.java.tracker;

import ru.itmo.java.message.torrent.Constants;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class TorrentTracker {
    private final ExecutorService readPool = Executors.newCachedThreadPool();
    Logger logger = Logger.getLogger(TorrentTracker.class.getName());

    public static void main(String[] args){
        TorrentTracker tracker = new TorrentTracker();
        tracker.run();
    }

    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(Constants.TRACKER_PORT)) {
            while (!Thread.interrupted()) {
                Socket socket = serverSocket.accept();
                logger.info("Client accepted");
                readPool.submit(new TorrentTrackerWorker(socket));
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