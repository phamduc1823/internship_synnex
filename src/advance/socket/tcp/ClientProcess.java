package advance.socket.tcp;

import java.io.*;
import java.net.Socket;

public class ClientProcess {
    Socket socket;
    BufferedReader netIn;
    PrintWriter netOut;
    BufferedReader userIn;

    public ClientProcess() throws IOException {
        this.socket = new Socket("localhost", 2211);
        this.netIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.netOut = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    public void mainProcess() throws IOException {
        //Nhan du lieu tu ben server gui ve
        String greeting = netIn.readLine();
        System.out.println(greeting);

        while (true){
            //Du lieu cua nguoi dung nhap tu man console
            userIn = new BufferedReader(new InputStreamReader(System.in));
            String commandd = userIn.readLine();

            //Gui len server = plush
            netOut.println(commandd);
            netOut.flush();

            //Nhan du lieu tra ve tu server
            String response = netIn.readLine();
            System.out.println("Server response: " + response);

            if(response.equalsIgnoreCase("close")){
                //Dung chuong trinh
                netIn.close();
                netOut.close();
                userIn.close();
                System.out.println("Server closed");
                break;
            }
        }
    }
}
