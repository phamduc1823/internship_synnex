package advance.socket.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;

public class Server {
    public static void main(String[] args) throws IOException {
        Queue<Commands> queue = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            Worker worker = new Worker(queue);
            worker.start();
        }
        ServerSocket serverSocket = new ServerSocket(2211);
        System.out.println("Waiting for client connection...");
        while (true) {
            //Chap nhan ket noi cua client
            Socket socket = serverSocket.accept();
            new ServerProcess(socket, queue).start();
            System.out.println("Client " + socket.getInetAddress() + " connected!");
        }
    }
}