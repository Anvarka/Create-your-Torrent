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
    static private final TrackerInformer trackerInformer = new TrackerInformer();
    private final ExecutorService writePool = Executors.newSingleThreadExecutor();
    Logger logger = Logger.getLogger(TorrentTrackerWorker.class.getName());
    UserInfo client;


    public TorrentTrackerWorker(Socket socket) {
        this.socket = socket;
        client = UserInfo.newBuilder()
                .setIp(socket.getInetAddress().getHostAddress())
                .setPort(socket.getPort())
                .build();
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
                        logger.info("Error request");
                        continue;
                    }
                    executeWriteTask(writeTask);
                }
            } catch (IOException e) {
                System.out.println("error in tracker file");
            }
        close();
        logger.info("Client disconnected");
    }

    private WriteTask handle(ListRequest listRequest) {
        logger.info("Get ListRequest");
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
        logger.info("Get UploadRequest");
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
        logger.info("Get UpdateRequest");
        UpdateAnswer b = trackerInformer.updateList(updateRequest, client);
        return () -> ResponseFromTracker.newBuilder()
                .setUpdateAnswer(b)
                .build()
                .writeDelimitedTo(socket.getOutputStream());
    }

    private WriteTask handle(SourcesRequest sourcesRequest) {
        logger.info("Get SourceRequest");
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
            writePool.shutdown();
            trackerInformer.close();
        } catch (IOException e){
            System.out.println("Error in tracker file");
        }

    }
}
