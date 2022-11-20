package ru.itmo.java.info;

import ru.itmo.java.message.torrent.FileSplitter;
import ru.itmo.java.message.torrent.UploadAnswer;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ClientInformer {
    private final ConcurrentHashMap<UploadAnswer, List<Long>> shareFileAndParts = new ConcurrentHashMap<>();

    public void addSharedFiles(UploadAnswer uploadAnswer){
        shareFileAndParts.put(uploadAnswer, FileSplitter.getParts(uploadAnswer.getSize()));
    }


}
