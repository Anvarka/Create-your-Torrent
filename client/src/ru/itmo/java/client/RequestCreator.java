package ru.itmo.java.client;

import ru.itmo.java.message.torrent.ListRequest;
import ru.itmo.java.message.torrent.RequestToTracker;
import ru.itmo.java.message.torrent.SourcesRequest;
import ru.itmo.java.message.torrent.UploadRequest;

import java.io.File;
import java.util.logging.Logger;

public class RequestCreator {
    Logger logger = Logger.getLogger(RequestCreator.class.getName());


    public RequestToTracker createListRequest() {
        logger.info("create ListRequest from client");
        var listRequest = ListRequest.newBuilder().build();
        return RequestToTracker.newBuilder().setListRequest(listRequest).build();
    }

    public RequestToTracker createUploadRequest(String[] args) {
        logger.info("create UploadRequest from client");
        String filename = args[1];
        File file = new File(filename);
        if (!file.exists() || !file.isFile()) {
            logger.warning("I don't find path to file");
            return null;
        }
        UploadRequest uploadRequest = UploadRequest.newBuilder().setFilename(filename).setSize(file.length()).build();
        return RequestToTracker.newBuilder().setUpload(uploadRequest).build();
    }

    public RequestToTracker createDownloadRequest(String[] args) {
        logger.info("create DownloadRequest from client");
        int idFile = Integer.parseInt(args[1]);
        logger.info("create SourcesRequest");
        SourcesRequest sourcesRequest = SourcesRequest.newBuilder()
                .setIdFile(idFile)
                .build();
        return RequestToTracker.newBuilder().setSources(sourcesRequest).build();
    }
}
