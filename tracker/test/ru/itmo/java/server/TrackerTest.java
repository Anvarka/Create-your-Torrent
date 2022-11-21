package ru.itmo.java.server;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ru.itmo.java.info.TrackerInformer;
import ru.itmo.java.message.torrent.*;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;


public class TrackerTest {
    @Test
    public void testList() throws IOException {
        // use file with state for tracker: have info about example.txt and example2.txt
        TrackerInformer trackerInformer = new TrackerInformer();
        // клиент кинул запрос
        UserInfo clientInfo = UserInfo.newBuilder().setIp("127.0.0.1").setPort(123).build();
        ListRequest listRequest = ListRequest.newBuilder().build();

        List<FileContent> files = trackerInformer.getListOfAvailableFiles();
        var listAnswer = ListAnswer.newBuilder()
                .setCountFile(files.size())
                .addAllFileContent(files)
                .build();

        Assertions.assertEquals(0, listAnswer.getCountFile());
//        List<Long> idFiles = new ArrayList<>();
//        List<String> filenames = new ArrayList<>();
//        List<Long> sizes = new ArrayList<>();
//        for(FileContent fileContent: listAnswer.getFileContentList()){
//            idFiles.add(fileContent.getIdFile());
//            filenames.add(fileContent.getFilename());
//            sizes.add(fileContent.getSizeFile());
//        }
//        // First file, which contains in tracker
//        Assertions.assertEquals(1, idFiles.get(0));
//        Assertions.assertEquals("client/resources/example2.txt", filenames.get(0));
//        Assertions.assertEquals(35, sizes.get(0));
//
//        // Second file, which contains in tracker
//        Assertions.assertEquals(0, idFiles.get(1));
//        Assertions.assertEquals("client/resources/example.txt", filenames.get(1));
//        Assertions.assertEquals(11, sizes.get(1));
    }

    @Test
    public void testSources() throws IOException {
        // without fix state
        TrackerInformer trackerInformer = new TrackerInformer();
        UploadRequest uploadRequest = UploadRequest.newBuilder()
                .setFilename("client/testResources/1.txt")
                .setSize(9)
                .build();
        UserInfo userInfo = UserInfo.newBuilder().setIp("127.0.0.1").setPort(123).build();
        trackerInformer.uploadFile(uploadRequest, userInfo);
        SourcesRequest sourcesRequest = SourcesRequest.newBuilder()
                .setIdFile(1)
                .build();

        SourcesAnswer sourcesAnswer = trackerInformer.sources(sourcesRequest);
        Assertions.assertEquals(0, sourcesAnswer.getClientWithFileCount());
        Assertions.assertEquals(0, sourcesAnswer.getSizeRes());
        Assertions.assertEquals(new ArrayList<UserInfo>(), sourcesAnswer.getClientWithFileList());
    }

//    @Test
//    public void testUpdate() throws UnknownHostException {
//        TrackerInformer trackerInformer = new TrackerInformer();
//        UserInfo clientInfo = UserInfo.newBuilder().setIp("127.0.0.1").setPort(123).build();
//        // create package
//        List<Long> fileIds = List.of(1L, 2L, 3L);
//        var uploadAnswer = UploadAnswer.newBuilder()
//                .setIdFile(fileInfo.getIdFile())
//                .setFilename(fileInfo.getFilename())
//                .setSize(fileInfo.getSizeFile())
//                .build();
//
//        UpdateRequest updateRequest = UpdateRequest.newBuilder().setUserInfo(clientInfo)
//                .setCountSharedFiles(3)
//                .addAllUploadAnswer(fileIds).setClientPort(123).setCountSharedFiles(3).build();
//
//        UpdateAnswer updateAnswer = handle(updateRequest, clientInfo);
//        Assertions.assertTrue(updateAnswer.getStatusUpdate());
//    }
    @Test
    public void testUpload() throws UnknownHostException {
        TrackerInformer trackerInformer = new TrackerInformer();
        UserInfo clientInfo = UserInfo.newBuilder().setIp("127.0.0.1").setPort(123).build();

        // create package
        String filename = "client/resources/example.txt";
        File file = new File(filename);
        long size = file.length();
        UploadRequest uploadRequest = UploadRequest.newBuilder().setFilename(filename).setSize(size).build();

        FileContent fileInfo = trackerInformer.uploadFile(uploadRequest, clientInfo);
        var uploadAnswer = UploadAnswer.newBuilder()
                .setFileContent(fileInfo)
                .build();
        Assertions.assertEquals(filename, uploadAnswer.getFileContent().getFilename());
        Assertions.assertEquals(size, uploadAnswer.getFileContent().getSizeFile());
        Assertions.assertEquals(0, uploadAnswer.getFileContent().getIdFile());
    }
}
