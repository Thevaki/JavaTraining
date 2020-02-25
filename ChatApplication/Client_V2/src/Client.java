
import javax.net.ssl.SSLSocketFactory;
import java.net.*;
import java.io.*;

public class Client {
    private static final String TRUSTSTORE_LOCATION = "E://VTraining/ChatApplication_V2/Keys/ServerKeyStore.jks";
    private static final String TRUSTSTORE_PASSWORD = "1234567";

    private String hostname;
    private int port;
    private String userName;

    public Client(String hostname, int port,String userName) {
        this.hostname = hostname;
        this.port = port;
        this.userName=userName;
    }

    public static void main(String[] args) {
        System.setProperty("javax.net.ssl.trustStore", TRUSTSTORE_LOCATION);
        System.setProperty("javax.net.ssl.trustStorePassword", TRUSTSTORE_PASSWORD);

        if (args.length < 3)
            return;

        String hostname = args[0];
        int port = Integer.parseInt(args[1]);
        String userName = args[2];

        Client client = new Client(hostname, port,userName);
        client.execute();
    }

    public void execute() {

        SSLSocketFactory sslSocketFactory =
                (SSLSocketFactory) SSLSocketFactory.getDefault();
        try {
            Socket socket = sslSocketFactory.createSocket(hostname, port);

            System.out.println("Connected to the chat server");

            new ReadConnection(socket, this).start();
            new SendConnection(socket, this).start();

        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O Error: " + ex.getMessage());
        }

    }

    void setUserName(String userName) {
        this.userName = userName;
    }

    String getUserName() {
        return this.userName;
    }

}