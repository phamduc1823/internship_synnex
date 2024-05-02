package advance.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) {
        try {
            //Tao socket ben server
            DatagramSocket serverSocket = new DatagramSocket(9876);

            while(true) {
                //Nhan du lieu
                byte[] receiveData = new byte[1024];
                //Gui du lieu
                byte[] sendData = new byte[1024];

                //Nhan goi tin tu client gui len
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                //Goi tin duoc gui den serverSocket
                serverSocket.receive(receivePacket);

                //Chuyen du lieu ve string
                String sentence = new String(receivePacket.getData());

                //Lay IP ben client
                InetAddress address = receivePacket.getAddress();

                //Lay port ben client
                int port = receivePacket.getPort();

                //Xu ly du lieu vua nhan
                String sentenceToClient = sentence + " server accepted!";

                //Tao goi tin gui qua client
                sendData = sentenceToClient.getBytes(); //Chuyen thanh mang byte
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address, port);
                serverSocket.send(sendPacket);
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
