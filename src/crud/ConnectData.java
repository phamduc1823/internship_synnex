package crud;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

public class ConnectData {
    private String filePath = "src/crud/configs.txt";
    private Map<String, String> config = readConfig(filePath);

    private final String dbConnection = config.get("DB_CONNECTION");
    private final String serverName = config.get("SERVER_NAME");
    private final String portNumber = config.get("PORT_NUMBER");
    private final String dbName = config.get("DB_NAME");
    private final String user = config.get("DB_USER");
    private final String password = config.get("DB_PASSWORD");

    public ConnectData() throws Exception {
    }

    private Map<String, String> readConfig(String filePath) throws Exception {

        Map<String, String> config = new HashMap<>();

        //Doc file
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        //reader.readLine() co dang
        //[DB_CONNECTION=mysql]

        while ((line = reader.readLine()) != null) {

            //Se co dang
            // [DB_CONNECTION, mysql]
            //[SERVER_NAME, localhost]
            String[] parts = line.split("=");

            //Kiem tra neu co 2 phan tu thi set Key va Value
            if (parts.length == 2) {
                //add cap Key - value khi bo khoang trong
                config.put(parts[0].trim(), parts[1].trim());
            }
        }

        reader.close();
        return config;
    }

    public Connection getConnection() throws Exception {
        String connectionURL = "jdbc:" +
                dbConnection + "://" +
                serverName + ":" +
                portNumber + "/" +
                dbName + "?zeroDateTimeBehavior=convertToNull";
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(connectionURL, user, password);
    }
}
