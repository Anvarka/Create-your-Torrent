package ru.itmo.java.tracker;

import ru.itmo.java.info.TrackerInformer;
import ru.itmo.java.message.torrent.Constants;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class TorrentTracker implements AutoCloseable {
    private final ExecutorService readPool = Executors.newCachedThreadPool();
    private final TrackerInformer trackerInformer = new TrackerInformer();
    Logger logger = Logger.getLogger(TorrentTracker.class.getName());

    private static void registerShutdownHook(TorrentTracker tracker) {
        Runtime.getRuntime().addShutdownHook(new Thread(tracker::close));
    }

    public static void main(String[] args) {
        TorrentTracker tracker = new TorrentTracker();
        registerShutdownHook(tracker);
        tracker.run();
    }

    public void run() {
        logger.info("Tracker is activated");
        try (ServerSocket serverSocket = new ServerSocket(Constants.TRACKER_PORT)) {
            while (!Thread.interrupted()) {
                Socket socket = serverSocket.accept();
                logger.info(String.format("client %s %s accepted", socket.getInetAddress(), socket.getPort()));
                readPool.submit(new TorrentTrackerWorker(socket, trackerInformer));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("Tracker is dead");
    }

    @Override
    public void close() {
        logger.info("Tracker is closed");
        try {
            trackerInformer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        readPool.shutdown();
    }
}