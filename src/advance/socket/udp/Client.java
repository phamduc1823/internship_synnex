package advance.socket.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        //Tao socket ben clien
        DatagramSocket clientSocket = new DatagramSocket(2231);

        //Tao dia chi IP
        InetAddress IPAddress = InetAddress.getByName("localhost");

        while(true){
            //Nhan du lieu
            byte[] receiveData = new byte[1024];
            //Gui du lieu
            byte[] sendData = new byte[1024];

            //Lay du lieu nhap tu ban phim va gan cho bien sentence
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            String sentence = inFromUser.readLine();

            //Chuyen du lieu va nhap thanh 1 mang bytes
            sendData = sentence.getBytes();

            //Gui du lieu len server
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
            clientSocket.send(sendPacket);

            //Nhan du lieu tu server
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            //Goi tin duoc gui den clientSocket
            clientSocket.receive(receivePacket);

            //Chuyen du lieu trong goi tin nhan duoc thanh String va in ra man hinh
            String modified_Sentence = new String(receivePacket.getData());
            System.out.println("FROM SERVER:" + modified_Sentence);

            if(sentence.compareTo("quit") == 0)
                break;
        }

        //Dong socket
        clientSocket.close();
    }
}
