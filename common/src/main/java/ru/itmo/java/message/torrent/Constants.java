package ru.itmo.java.message.torrent;

public class Constants {
    public static final int TRACKER_PORT = 8081;
    public static final String HOST = "localhost";

    // client inteface
    public static final String LIST_CMD = "list";
    public static final String UPLOAD_CMD = "upload";
    public static final String DOWNLOAD_CMD = "download";

    public static final String CLIENT_STATE_PATH = "client/testResources/init_state_of_client.txt";
    public static final String TRACKER_STATE_PATH = "tracker/testResources/init_state_of_tracker.txt";
    public static final String SAVE_DIR = "client/resources/";

    public static final long UPDATE_TIME_SLEEP = 30000;
    public static final long ALIVE_TIME_LIMIT = 50000;
    public static final long FILE_PART_SIZE = 100;

    public static final String CLIENT_RULE = "You can use these commands:\n" +
            "list -- for watching exist share files in tracker\n" +
            "upload [FILENAME] -- for sharing your file\n" +
            "download [ID_FILE] -- for download file with this id";

    public static final String TRACKER_RULE = "You can use these commands:" +
            "list -- for watching exist share files in tracker" +
            "upload [FILENAME] -- for sharing your file";
}
