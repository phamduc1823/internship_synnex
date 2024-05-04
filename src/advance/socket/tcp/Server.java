package advance.socket.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(2211);
        Object lock = new Object();
        Queue<Socket> queue = new LinkedList<>();

        ServerThread serverThread = new ServerThread(serverSocket, lock, queue);
        serverThread.start();

        System.out.println("Server is active!");

        while (true) {
            synchronized (lock) {
                while (queue.isEmpty()) {
                    try {
                        lock.wait();
                        System.out.println("Queue is empty! wait client connect ...");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Socket socket = queue.poll();
                new ServerProcess(socket).start();
            }
        }
    }
}