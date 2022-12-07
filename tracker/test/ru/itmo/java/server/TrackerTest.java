package ru.itmo.java.server;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.itmo.java.info.TrackerInformer;
import ru.itmo.java.message.torrent.*;

import java.util.ArrayList;
import java.util.List;


public class TrackerTest {
    TrackerInformer trackerInformer;

    @BeforeEach
    public void addFiles() {
        trackerInformer = new TrackerInformer();
        UserInfo userInfo = UserInfo.newBuilder().setIp("127.0.0.1").setPort(123).build();
        UploadRequest uploadRequest1 = UploadRequest.newBuilder()
                .setSize(123)
                .setFilename("client/testResources/1.txt")
                .build();
        UploadRequest uploadRequest2 = UploadRequest.newBuilder()
                .setSize(200)
                .setFilename("client/testResources/2.txt")
                .build();
        trackerInformer.uploadFile(uploadRequest1, userInfo);
        trackerInformer.uploadFile(uploadRequest2, userInfo);

        FileContent fileContent1 = FileContent.newBuilder()
                .setSizeFile(123)
                .setFilename("client/testResources/1.txt")
                .setIdFile(1)
                .build();
        FileContent fileContent2 = FileContent.newBuilder()
                .setSizeFile(200)
                .setFilename("client/testResources/2.txt")
                .setIdFile(2)
                .build();
        UserInfo clientInfo1 = UserInfo.newBuilder().setIp("127.0.0.1").setPort(123).build();
        UserInfo clientInfo2 = UserInfo.newBuilder().setIp("127.0.0.2").setPort(200).build();
        UpdateRequest updateRequest1 = UpdateRequest.newBuilder().addFileContent(fileContent1).build();
        UpdateRequest updateRequest2 = UpdateRequest.newBuilder().addFileContent(fileContent2).build();
        trackerInformer.updateList(updateRequest1, clientInfo1);
        trackerInformer.updateList(updateRequest2, clientInfo2);
    }

    @Test
    public void testList() {

        List<FileContent> files = trackerInformer.getListOfAvailableFiles();
        var listAnswer = ListAnswer.newBuilder()
                .addAllFileContent(files)
                .build();

        Assertions.assertEquals(2, listAnswer.getFileContentList().size());
        List<Long> idFiles = new ArrayList<>();
        List<String> filenames = new ArrayList<>();
        List<Long> sizes = new ArrayList<>();
        for (FileContent fileContent : listAnswer.getFileContentList()) {
            idFiles.add(fileContent.getIdFile());
            filenames.add(fileContent.getFilename());
            sizes.add(fileContent.getSizeFile());
        }
        // First file, which contains in tracker
        Assertions.assertEquals(1, idFiles.get(0));
        Assertions.assertEquals("client/testResources/1.txt", filenames.get(0));
        Assertions.assertEquals(123, sizes.get(0));

        // Second file, which contains in tracker
        Assertions.assertEquals(2, idFiles.get(1));
        Assertions.assertEquals("client/testResources/2.txt", filenames.get(1));
        Assertions.assertEquals(200, sizes.get(1));
    }

    @Test
    public void testSources() {
        UserInfo clientInfo1 = UserInfo.newBuilder().setIp("127.0.0.1").setPort(123).build();
        UserInfo clientInfo2 = UserInfo.newBuilder().setIp("127.0.0.2").setPort(200).build();
        List<UserInfo> l = new ArrayList<>();
        l.add(clientInfo1);
        l.add(clientInfo2);

        for (int i = 0; i < 2; i++) {
            SourcesRequest sourcesRequest = SourcesRequest.newBuilder()
                    .setIdFile(i+1)
                    .build();
//
            SourcesAnswer sourcesAnswer = trackerInformer.sources(sourcesRequest);
            Assertions.assertEquals(i + 1, sourcesAnswer.getIdFile());
            Assertions.assertEquals(l.get(i).getIp(), sourcesAnswer.getClientWithFileList().get(0).getIp());
        }
    }
        @Test
        public void testUpload() {
            List<FileContent> fileContentList = trackerInformer.getListOfAvailableFiles();
            Assertions.assertEquals(1, fileContentList.get(0).getIdFile());
            Assertions.assertEquals(2, fileContentList.get(1).getIdFile());

            Assertions.assertEquals(123, fileContentList.get(0).getSizeFile());
            Assertions.assertEquals(200, fileContentList.get(1).getSizeFile());

            Assertions.assertEquals("client/testResources/1.txt", fileContentList.get(0).getFilename());
            Assertions.assertEquals("client/testResources/2.txt", fileContentList.get(1).getFilename());
        }
    }
