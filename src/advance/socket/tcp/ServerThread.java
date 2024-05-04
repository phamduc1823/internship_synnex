package advance.socket.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Queue;

class ServerThread extends Thread {
    ServerSocket serverSocket;
    Object lock;
    Queue<Socket> queue;

    public ServerThread(ServerSocket serverSocket, Object lock, Queue<Socket> queue) {
        this.serverSocket = serverSocket;
        this.lock = lock;
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                synchronized (lock) {
                    while (queue.size() == 1) {
                        lock.wait();
                        System.out.println("Queue is full! wait server handle ...");
                    }
                    queue.add(socket);
                    lock.notify();
                    System.out.println("Client " + socket.getInetAddress() + " connected!");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}