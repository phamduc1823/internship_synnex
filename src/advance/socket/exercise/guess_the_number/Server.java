package advance.socket.exercise.guess_the_number;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            System.out.println("Dang doi client ket noi...");

            while (true) {
                Socket socket = serverSocket.accept();
                new ServerThread(socket).start();
                System.out.println("Client co IP: " + socket.getInetAddress() + " ket noi thanh cong!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
