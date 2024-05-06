package advance.socket.tcp;

import java.io.*;
import java.net.Socket;
import java.util.Queue;

public class ServerProcess extends Thread {
    Socket socket;
    BufferedReader netIn;
    PrintWriter netOut;
    Queue<Commands> commandsQueue;

    public ServerProcess(Socket socket, Queue<Commands> commandsQueue) {
        try {
            this.socket = socket;
            this.netIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.netOut = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.commandsQueue = commandsQueue;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        netOut.println("Hello Client");
        netOut.flush();

        while (true) {
            String command;
            try {
                //Nhan du lieu tu client
                command = netIn.readLine();
                if (command != null) {
                    if (command.equalsIgnoreCase("exit")) {
                        //tra du lieu ve client va dung chuong trinh
                        netOut.println("Bye Client");
                        netOut.flush();
                        netIn.close();
                        netOut.close();
                        break;
                    } else {
                        //tra du lieu ve client
                        this.commandsQueue.add(new Commands(command, netOut));
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}