package advance.socket.tcp;

import java.io.*;
import java.net.Socket;

public class ServerProcess extends Thread {
    Socket socket;
    BufferedReader netIn;
    PrintWriter netOut;

    public ServerProcess(Socket socket) {
        try {
            this.socket = socket;
            this.netIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.netOut = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
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
                        netOut.println(command);
                        netOut.flush();
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
