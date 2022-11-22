package ru.itmo.java.client;

import ru.itmo.java.message.torrent.ListRequest;
import ru.itmo.java.message.torrent.RequestToTracker;
import ru.itmo.java.message.torrent.SourcesRequest;
import ru.itmo.java.message.torrent.UploadRequest;

import java.io.File;

public class RequestCreator {
    public static RequestToTracker createListRequest() {
        var listRequest = ListRequest.newBuilder().build();
        return RequestToTracker.newBuilder().setListRequest(listRequest).build();
    }

    public static RequestToTracker createUploadRequest(String[] args) {
        String filename = args[1];
        File file = new File(filename);
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        UploadRequest uploadRequest = UploadRequest.newBuilder().setFilename(filename).setSize(file.length()).build();
        return RequestToTracker.newBuilder().setUpload(uploadRequest).build();
    }

    public static RequestToTracker createSetupRequest(String[] args) {
        int idFile = Integer.parseInt(args[1]);
        SourcesRequest sourcesRequest = SourcesRequest.newBuilder()
                .setIdFile(idFile)
                .build();
        return RequestToTracker.newBuilder().setSources(sourcesRequest).build();
    }
}
