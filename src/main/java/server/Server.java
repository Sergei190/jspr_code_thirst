package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static final int SERVER_PORT = 25757;
    private final ExecutorService threadPool = Executors.newFixedThreadPool(64);

    public void start() {
        try (var serverSocket = new ServerSocket(SERVER_PORT)) {
            while (true) {
                var socket = serverSocket.accept();
                var thread = new Handler(socket);
                threadPool.submit(thread);
            }
        } catch (IOException ex) {
            ex.getMessage();
        }
    }
}