package ru.itmo.java.message.torrent;

public class Constants {
    public static final int TRACKER_PORT = 8081;
    public static final int CLIENT_SERVER_PORT = 0;
    public static final String UPLOAD = "upload";
    public static final String LIST = "list";

    public static final String SETUP = "setup";
    public static final String CLIENT_STATE_PATH = "client/testResources/KeeperInformationAboutClient.txt";
    public static final String TRACKER_STATE_PATH = "tracker/testResources/TrackerState.txt";

    public static final long UPDATE_TIME_SLEEP = 30000;
    public static final long ALIVE_TIME_LIMIT = 50000;
    public static final long FILE_PART_SIZE = 1;
}
