
import java.io.*;
import java.net.*;

public class SendConnection extends Thread {
    private PrintWriter writer;
    private Socket socket;
    private Client client;

    public SendConnection(Socket socket, Client client) {
        this.socket = socket;
        this.client = client;

        try {
            OutputStream output = socket.getOutputStream();
            writer = new PrintWriter(output, true);
        } catch (IOException ex) {
            System.out.println("Error getting output stream: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void run() {

        Console console = System.console();

        client.setUserName(client.getUserName());
        writer.println(client.getUserName());

        String text=client.getUserName();

        while (!text.equals("bye")){
            text = console.readLine("[" + client.getUserName() + "]: ");
            //text = client.getUserName();
            writer.println(text);

        }

        try {
            socket.close();
        } catch (IOException ex) {

            System.out.println("Error writing to server: " + ex.getMessage());
        }
    }
}