package ru.itmo.java.client;


import ru.itmo.java.info.ClientInformer;
import ru.itmo.java.message.torrent.*;
import ru.itmo.java.reminder.ReminderToServer;
import ru.itmo.java.server.ClientServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

import static ru.itmo.java.message.torrent.Constants.*;


public class Client implements AutoCloseable {
    public final Socket trackerSocket;
    private final Scanner scanner;
    private final ExecutorService readPool = Executors.newSingleThreadExecutor();
    private final ExecutorService writePool = Executors.newSingleThreadExecutor();
    private final Logger logger = Logger.getLogger(Client.class.getName());
    public final ServerSocket serverSocket;
    private final Thread reminder;
    public final ClientInformer clientInformer = new ClientInformer();
    private final Thread clientServer;
    private final RequestCreator requestCreator = new RequestCreator();
    public final HandlerResponseFromTracker handlerResponseFromTracker;
    public final HandlerResponseFromClientServer handleResponseFromClientServer;


    public Client(Socket socket, Scanner scanner, int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
        logger.info("client init");
        this.trackerSocket = socket;
        this.scanner = scanner;
        clientInformer.getStateFromFile();
        reminder = new Thread(new ReminderToServer(trackerSocket, serverSocket, this, clientInformer));
        reminder.start();
        clientServer = new Thread(new ClientServer(clientInformer, serverSocket));
        clientServer.start();
        handleResponseFromClientServer = new HandlerResponseFromClientServer(this, clientInformer);
        handlerResponseFromTracker = new HandlerResponseFromTracker(trackerSocket, this, clientInformer, handleResponseFromClientServer);
    }

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(HOST, TRACKER_PORT);
            Scanner scanner = new Scanner(System.in);
            int port = Integer.parseInt(args[0]);
            var client = new Client(socket, scanner, port);
            registerShutdownHook(client);
            client.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void registerShutdownHook(Client client) {
        Runtime.getRuntime().addShutdownHook(new Thread(client::close));
    }

    public void run() {
        while (scanner.hasNextLine() && !Thread.interrupted() && !trackerSocket.isClosed()) {
            try {
                String commandStr = scanner.nextLine();
                String[] commandSplit = commandStr.split(" ");
                String command = commandSplit[0];
                clientInterface(trackerSocket, command, commandSplit);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        close();
    }

    public void clientInterface(Socket socket, String command, String[] args) {
        RequestToTracker request = switch (command) {
            case LIST_CMD -> requestCreator.createListRequest();
            case UPLOAD_CMD -> requestCreator.createUploadRequest(args);
            case DOWNLOAD_CMD -> requestCreator.createDownloadRequest(args);
            default -> null;
        };
        if (request == null) {
            logger.warning(String.format("No correct request for command: %s", command));
            logger.info(CLIENT_RULE);
            return;
        }
        executeWriteTask(() -> {
                    request.writeDelimitedTo(socket.getOutputStream());
                    executeReadTask(handlerResponseFromTracker::handleResponseFromTracker);
                }
        );
        logger.info("Client: request send");
    }

    public void executeWriteTask(WriteTask task) {
        writePool.submit(() -> {
            try {
                task.run();
            } catch (IOException ignored) {
            }
        });
    }

    public void executeReadTask(WriteTask task) {
        readPool.submit(() -> {
            try {
                task.run();
            } catch (IOException ignored) {
            }
        });
    }

    @Override
    public void close() {
        try {
            logger.info("Client is closing! Goodbye!");
            trackerSocket.close();
            readPool.shutdown();
            writePool.shutdown();
            reminder.interrupt();
            clientServer.interrupt();
            clientInformer.close();
        } catch (IOException e) {
            logger.warning("Error in close");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
