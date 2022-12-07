package ru.ifmo.java.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.itmo.java.message.*;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ClientTest {
//    @Test
//    public void testFileManager() throws IOException {
//        FileManager fileManager =  new FileManager();
//        long fileSize = 10_485_761;
//        Assertions.assertEquals(2, fileManager.getParts(fileSize).size());
//        fileSize = 1;
//        Assertions.assertEquals(1, fileManager.getParts(fileSize).size());
//        fileSize = 10_485_760;
//        Assertions.assertEquals(1, fileManager.getParts(fileSize).size());
//
//        RandomAccessFile f  = new RandomAccessFile("testResources/testClient.txt", "r");
//        byte[] content = new byte[(int) (f.length())];
//        f.readFully(content);
//        Assertions.assertEquals(1, fileManager.getParts(f.length()).size());
//        FileInfo fileInfo = new FileInfo(f.length(), "testResources/testClient.txt", 0);
//        byte[] res = fileManager.getContentFromPart(fileInfo,0L);
//        for(int i = 0; i < content.length; i++){
//            Assertions.assertEquals(content[i], res[i]);
//        }
//    }
}
