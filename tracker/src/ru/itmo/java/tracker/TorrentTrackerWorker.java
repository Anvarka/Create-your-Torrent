package ru.itmo.java.tracker;

import ru.itmo.java.info.TrackerInformer;
import ru.itmo.java.message.torrent.*;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class TorrentTrackerWorker implements Runnable, AutoCloseable {
    private final Socket socket;
    private final TrackerInformer trackerInformer;
    private final ExecutorService writePool = Executors.newSingleThreadExecutor();
    Logger logger = Logger.getLogger(TorrentTrackerWorker.class.getName());
    UserInfo client;

    public TorrentTrackerWorker(Socket socket, TrackerInformer trackerInformer) {
        this.socket = socket;
        this.trackerInformer = trackerInformer;
        client = UserInfo.newBuilder()
                .setIp(socket.getInetAddress().getHostAddress())
                .setPort(socket.getPort())
                .build();
        logger.info(String.format("TorrentTrackerWorker is activated for client with %s, %s",client.getIp(), client.getPort()));
    }

    @Override
    public void run() {
        try (Socket socket = this.socket) {
            while (!Thread.interrupted()) {
                RequestToTracker requestFromClient = RequestToTracker.parseDelimitedFrom(socket.getInputStream());
                WriteTask writeTask = switch (requestFromClient.getRequestCase()) {
                    case LISTREQUEST -> handle(requestFromClient.getListRequest());
                    case UPLOAD -> handle(requestFromClient.getUpload());
                    case UPDATE -> handle(requestFromClient.getUpdate());
                    case SOURCES -> handle(requestFromClient.getSources());
                    default -> null;
                };
                if (writeTask == null) {
                    logger.warning(String.format("no valid request %s", requestFromClient.getRequestCase()));
                    logger.info(Constants.TRACKER_RULE);
                    continue;
                }
                executeWriteTask(writeTask);
            }
        } catch (IOException e) {
            logger.warning(String.format("Error in tracker file: %s", e.getMessage()));
        }
        logger.info(String.format("client with %s, %s disconnected", client.getIp(), client.getPort()));
    }

    private WriteTask handle(ListRequest listRequest) {
        logger.info(String.format("Get ListRequest from client with %s, %s", client.getIp(),client.getPort()));
        List<FileContent> files = trackerInformer.getListOfAvailableFiles();
        var listAnswer = ListAnswer.newBuilder()
                .addAllFileContent(files)
                .build();
        return () -> ResponseFromTracker.newBuilder()
                .setListAnswer(listAnswer)
                .build()
                .writeDelimitedTo(socket.getOutputStream());
    }

    private WriteTask handle(UploadRequest uploadRequest) {
        logger.info(String.format("Get UploadRequest from client with %s, %s", client.getIp(), client.getPort()));
        FileContent fileInfo = trackerInformer.uploadFile(uploadRequest, client);
        var uploadAnswer = UploadAnswer.newBuilder()
                .setFileContent(fileInfo)
                .build();
        return () -> ResponseFromTracker.newBuilder()
                .setUploadAnswer(uploadAnswer)
                .build()
                .writeDelimitedTo(socket.getOutputStream());
    }

    private WriteTask handle(UpdateRequest updateRequest) {
        logger.info(String.format("Get UpdateRequest from client with %s, %s", client.getIp(), client.getPort()));
        UpdateAnswer updateAnswer = trackerInformer.updateList(updateRequest, client);
        return () -> ResponseFromTracker.newBuilder()
                .setUpdateAnswer(updateAnswer)
                .build()
                .writeDelimitedTo(socket.getOutputStream());
    }

    private WriteTask handle(SourcesRequest sourcesRequest) {
        logger.info(String.format("Get SourceRequest from client with %s, %s", client.getIp(), client.getPort()));
        SourcesAnswer sourcesAnswer = trackerInformer.sources(sourcesRequest);

        return () -> ResponseFromTracker.newBuilder()
                .setSourcesAnswer(sourcesAnswer)
                .build()
                .writeDelimitedTo(socket.getOutputStream());
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
        try {
            socket.close();
            writePool.shutdown();
        } catch (IOException e) {
            logger.warning(e.getMessage());
        }
    }
}
