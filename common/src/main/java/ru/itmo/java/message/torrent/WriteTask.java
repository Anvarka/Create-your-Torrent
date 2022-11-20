package ru.itmo.java.message.torrent;

import java.io.IOException;

public interface WriteTask {
    void run() throws IOException;
}

