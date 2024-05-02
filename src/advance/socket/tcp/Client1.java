package advance.socket.tcp;

import java.io.IOException;

public class Client1 {
    public static void main(String[] args) throws IOException {
        ClientProcess client = new ClientProcess();
        client.mainProcess();
    }
}
