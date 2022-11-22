package ru.itmo.java.info;

import ru.itmo.java.message.torrent.Constants;
import ru.itmo.java.message.torrent.FileContent;
import ru.itmo.java.message.torrent.FileSplitter;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ClientInformer {
    private final Lock lock = new ReentrantLock();
    private final ConcurrentHashMap<FileContent, List<Long>> shareFileAndParts = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Long, List<Socket>> partAndUserSockets = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Long, FileContent> idFileAndContent = new ConcurrentHashMap<>();

    public void addSharedFiles(FileContent fileContent, List<Long> parts) {
//        lock.lock();
//        try {
            shareFileAndParts.put(fileContent, parts);
            idFileAndContent.put(fileContent.getIdFile(), fileContent);
//        } finally {
//            lock.unlock();
//        }
    }

    public void addSharedFile(FileContent fileContent, Long part) {
//        lock.lock();
//        try {
            if (shareFileAndParts.contains(fileContent)) {
                shareFileAndParts.put(fileContent, new ArrayList<>());
            }
            shareFileAndParts.get(fileContent).add(part);
//        } finally {
//            lock.unlock();
//        }
    }

    public ConcurrentHashMap.KeySetView<FileContent, List<Long>> getAllSharedFiles() {
//        lock.lock();
//        try {
            return shareFileAndParts.keySet();
//        } finally {
//            lock.unlock();
//        }
    }


    public List<Long> getPartsOfFile(Long idFile) {
//        lock.lock();
//        try {
            return shareFileAndParts.get(idFileAndContent.get(idFile));
//        } finally {
//            lock.unlock();
//        }
    }

    public FileContent getContentOfFile(Long idFile) {
//        lock.lock();
//        try {
            return idFileAndContent.get(idFile);
//        } finally {
//            lock.unlock();
//        }
    }

    public void addHowCLientWithPart(List<Long> parts, Socket socket) {
//        lock.lock();
//        try {
            for (var part : parts) {
                if (!partAndUserSockets.contains(part)) {
                    partAndUserSockets.put(part, new ArrayList<>());
                }
                partAndUserSockets.get(part).add(socket);
            }
//        } finally {
//            lock.unlock();
//        }
    }

    public ConcurrentHashMap<Long, List<Socket>> getPartAndUserSockets() {
        return partAndUserSockets;
    }

    public void getStateFromFile() {
//        lock.lock();
        try {
            File file = new File(Constants.CLIENT_STATE_PATH);
            if (file.exists() && file.isFile()) {
                DataInputStream in = new DataInputStream(new FileInputStream(file));

                int count = in.readInt();
                for (int i = 0; i < count; i++) {
                    FileContent fileContent = FileContent.newBuilder()
                            .setIdFile(in.readLong())
                            .setFilename(in.readUTF())
                            .setSizeFile(in.readLong())
                            .build();
                    shareFileAndParts.put(fileContent, FileSplitter.getParts(fileContent.getSizeFile()));
                }
            }
        } catch (FileNotFoundException ignored) {
            System.out.println("no file");
        } catch (IOException e) {
            System.out.println("no data");
        }
//        finally {
//            lock.unlock();
//        }
    }

    public void writeStateToFile() {
        DataOutputStream out;
        try {
            out = new DataOutputStream(new FileOutputStream(Constants.CLIENT_STATE_PATH));
            out.writeInt(shareFileAndParts.size());

            for (var l : shareFileAndParts.entrySet()) {
                out.writeLong(l.getKey().getIdFile());
                out.writeUTF(l.getKey().getFilename());
                out.writeLong(l.getKey().getSizeFile());
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
