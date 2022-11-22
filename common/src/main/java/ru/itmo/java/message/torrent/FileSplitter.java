package ru.itmo.java.message.torrent;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileSplitter {

    public static List<Long> getParts(long size) {
        long countBlocks = (size + Constants.FILE_PART_SIZE - 1) / Constants.FILE_PART_SIZE;
        List<Long> listOfParts = new ArrayList<>();
        for (long i = 0; i < countBlocks; i++) {
            listOfParts.add(i);
        }
        return listOfParts;
    }

    public static byte[] getContentFromPart(FileContent fileInfo, Long partId) {
        byte[] content = new byte[0];
        try {
            RandomAccessFile file = new RandomAccessFile(fileInfo.getFilename(), "r");
            long startBlock = partId * Constants.FILE_PART_SIZE;
            file.seek(startBlock);
            System.out.println("startBlock:");
            System.out.println(startBlock);
            long endBlock = startBlock + Constants.FILE_PART_SIZE;
            if (endBlock > fileInfo.getSizeFile()) {
                endBlock = fileInfo.getSizeFile();
            }
            content = new byte[(int) (endBlock - startBlock)];
            file.readFully(content);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }

    public static void writeContentToPartOfFile(FileContent fileInfo, long partId, byte[] bytes) throws IOException {
        long startBlock = partId * Constants.FILE_PART_SIZE;

        long endBlock = startBlock + Constants.FILE_PART_SIZE;
        if (endBlock > fileInfo.getSizeFile()) {
            endBlock = fileInfo.getSizeFile();
        }
        String path = Constants.SAVE_DIR + fileInfo.getIdFile();

        RandomAccessFile file = new RandomAccessFile(path, "rw");
        file.setLength(fileInfo.getSizeFile());
        byte[] content = Arrays.copyOf(bytes, (int) (endBlock - startBlock));
        file.seek(startBlock);
        file.write(content);
        file.close();
    }
}
