package ru.itmo.java.info;

import ru.itmo.java.message.torrent.*;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TrackerInformer {
    private final ConcurrentHashMap<Long, Set<UserInfo>> idFileUsers = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Long, FileContent> idFileAndInfo = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<UserInfo, Set<Long>> activeUsersIdFiles = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<UserInfo, Integer> activeUsersServerPorts = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<UserInfo, Long> userAndTime = new ConcurrentHashMap<>();
    private final AtomicLong currentId = new AtomicLong(0);

    private final Lock lock = new ReentrantLock();

    public TrackerInformer() {
        getStateFromFile();
    }

    public List<FileContent> getListOfAvailableFiles() {
        List<FileContent> fileContentList;
        lock.lock();
        try {
            fileContentList = new ArrayList<>();
            for (Long idFile : idFileUsers.keySet()) {
                FileContent fileContent = idFileAndInfo.get(idFile);
                fileContentList.add(fileContent);
            }
        } finally {
            lock.unlock();
        }
        return fileContentList;
    }

    public FileContent uploadFile(UploadRequest request, UserInfo userInfo) {
        lock.lock();
        FileContent fileInfo;
        try {
            long idFile = currentId.incrementAndGet();
            fileInfo = FileContent.newBuilder()
                    .setIdFile(idFile)
                    .setFilename(request.getFilename())
                    .setSizeFile(request.getSize())
                    .build();

            idFileAndInfo.putIfAbsent(idFile, fileInfo);

            if (!idFileUsers.containsKey(idFile)) {
                idFileUsers.computeIfAbsent(idFile, (key) -> new HashSet<>());
            }
            idFileUsers.get(idFile).add(userInfo);

            if (!activeUsersIdFiles.containsKey(userInfo)) {
                activeUsersIdFiles.computeIfAbsent(userInfo, (key) -> new HashSet<>());
            }
            activeUsersIdFiles.get(userInfo).add(idFile);

        } finally {
            lock.unlock();
        }
        return fileInfo;
    }

    public UpdateAnswer updateList(UpdateRequest request, UserInfo userInfo) {
        List<FileContent> uploadAnswers = request.getFileContentList();
        lock.lock();
        try {
            userAndTime.put(userInfo, System.currentTimeMillis());
            Set<Long> idFiles = new HashSet<>();
            for (var uploadAnswer : uploadAnswers) {
                FileContent fileContent = FileContent.newBuilder()
                        .setIdFile(uploadAnswer.getIdFile())
                        .setFilename(uploadAnswer.getFilename())
                        .setSizeFile(uploadAnswer.getSizeFile())
                        .build();
                idFileAndInfo.put(uploadAnswer.getIdFile(), fileContent);

                var idFile = uploadAnswer.getIdFile();
                if (!idFileUsers.containsKey(idFile)) {
                    idFileUsers.computeIfAbsent(idFile, (key) -> new HashSet<>());
                }
                idFileUsers.get(idFile).add(userInfo);
                idFiles.add(uploadAnswer.getIdFile());
            }
            activeUsersServerPorts.put(userInfo, request.getPortOfClientServer());
            activeUsersIdFiles.put(userInfo, idFiles);
            timeChecker();
        } finally {
            lock.unlock();
        }
        return UpdateAnswer.newBuilder().
                setStatusUpdate(true)
                .build();

    }

    private void timeChecker() {
        long curTime = System.currentTimeMillis();

        for (Map.Entry<UserInfo, Long> time : userAndTime.entrySet()) {
            if (Constants.ALIVE_TIME_LIMIT < curTime - time.getValue()) {
                userAndTime.remove(time.getKey());
                Set<Long> idFiles = activeUsersIdFiles.remove(time.getKey());
                for (var id : idFiles) {
                    idFileAndInfo.remove(id);
                    idFileUsers.get(id).remove(time.getKey());
                }
            }
        }
    }

    public SourcesAnswer sources(SourcesRequest request) {
        long idFile = request.getIdFile();

        List<UserInfo> res = new ArrayList<>();
        lock.lock();
        try {
            for (Map.Entry<UserInfo, Set<Long>> entry : activeUsersIdFiles.entrySet()) {
                if (entry.getValue().contains(idFile)) {
                    UserInfo clientInfo = entry.getKey();
                    int port = activeUsersServerPorts.get(clientInfo);
                    UserInfo clientIpAndPort = UserInfo.newBuilder().setPort(port).setIp(clientInfo.getIp()).build();
                    res.add(clientIpAndPort);
                }
            }
        } finally {
            lock.unlock();
        }

        return SourcesAnswer.newBuilder()
                .addAllClientWithFile(res)
                .setIdFile(idFile)
                .build();
    }

    public void getStateFromFile() {
        try {
            File file = new File(Constants.TRACKER_STATE_PATH);
            if (file.exists() && file.isFile()) {
                DataInputStream in = new DataInputStream(new FileInputStream(file));
                int count = in.readInt();
                for (int i = 0; i < count; i++) {
                    var fileContent = FileContent.newBuilder()
                            .setIdFile(in.readLong())
                            .setFilename(in.readUTF())
                            .setSizeFile(in.readLong())
                            .build();
                    idFileAndInfo.put(fileContent.getIdFile(), fileContent);
                }
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveState() {
        lock.lock();
        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream(Constants.TRACKER_STATE_PATH));
            out.writeInt(idFileAndInfo.size());

            for (var l : idFileAndInfo.entrySet()) {
                out.writeLong(l.getKey());
                out.writeUTF(l.getValue().getFilename());
                out.writeLong(l.getValue().getSizeFile());
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void close() throws IOException {
        saveState();
    }
}
