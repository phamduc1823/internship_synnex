package advance.socket.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(2211);
        System.out.println("Waiting for client connection...");
        while (true) {
            //Chap nhan ket noi cua client
            Socket socket = serverSocket.accept();
            new ServerProcess(socket).start();
            System.out.println("Client " + socket.getInetAddress() + " connected!");
        }
    }
}
