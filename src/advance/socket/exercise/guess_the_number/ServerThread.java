package advance.socket.exercise.guess_the_number;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread {
    public Socket socket;
    public BufferedReader in;
    public PrintWriter out;

    public ServerThread(Socket socket) throws IOException {
        this.socket = socket;
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    public void run() {
        out.println("Server: hay nhap so tu 0 - 10!");
        out.flush();

        while (true){
            try {
                int command = Integer.parseInt(in.readLine());

                if(command == 5){
                    out.println("true");
                    out.flush();
                }else{
                    out.println("Da nhap sai moi nhap lai!");
                    out.flush();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
