package ru.ifmo.java.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.itmo.java.client.RequestCreator;
import ru.itmo.java.message.torrent.RequestToTracker;

import java.io.IOException;

public class ClientTest {
    @Test
    public void testRequestCreator() throws IOException {
        RequestCreator requestCreator = new RequestCreator();
        RequestToTracker request = requestCreator.createListRequest();
        Assertions.assertTrue(request.hasListRequest());
        String[] arg = new String[2];
        arg[1] = "1";
        RequestToTracker request2 = requestCreator.createDownloadRequest(arg);
        Assertions.assertTrue(request2.hasSources());
    }
}
