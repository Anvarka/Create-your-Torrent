package ru.itmo.java.info;

import ru.itmo.java.message.torrent.FileContent;
import ru.itmo.java.message.torrent.FileSplitter;
import ru.itmo.java.message.torrent.UploadAnswer;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ClientInformer {
    private final ConcurrentHashMap<FileContent, List<Long>> shareFileAndParts = new ConcurrentHashMap<>();

    public void addSharedFiles(FileContent uploadAnswer){
        shareFileAndParts.put(uploadAnswer, FileSplitter.getParts(uploadAnswer.getSizeFile()));
    }

    public ConcurrentHashMap.KeySetView<FileContent, List<Long>> getAllSharedFiles(){
        return shareFileAndParts.keySet();
    }


}
