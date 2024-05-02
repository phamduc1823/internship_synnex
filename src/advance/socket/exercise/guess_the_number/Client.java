package advance.socket.exercise.guess_the_number;

import java.io.*;
import java.net.Socket;

public class Client {
    public Socket socket;
    public BufferedReader in;
    public PrintWriter out;
    public BufferedReader userIn;

    public Client() throws IOException {
        this.socket = new Socket("localhost", 9999);
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    public void connectServer() throws IOException {
        String data = in.readLine();
        System.out.println(data);

        int i = 5;
        while (i > 0) {
            System.out.println("Ban con "+ i + " lan nhap");
            userIn = new BufferedReader(new InputStreamReader(System.in));
            String command = userIn.readLine();

            //Gui len server
            out.println(command);
            out.flush();

            //Nhan du lieu tra ve tu server
            String response = in.readLine();
            System.out.println(response);
            if (response.equalsIgnoreCase("true")){
                System.out.println("Ban da nhap dung!");
                in.close();
                out.close();
                socket.close();
                break;
            }

            i--;
        }
        System.out.println("Da het luot nhap!");
        in.close();
        out.close();
        socket.close();
    }

    public static void main(String[] args) throws IOException {
        new Client().connectServer();
    }
}
