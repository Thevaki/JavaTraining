import javax.net.ssl.SSLServerSocketFactory;
import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    private int port;
    private Set<String> userNames = new HashSet<>();
    private Set<UserThread> userThreads = new HashSet<>();

    public Server(int port) {
        this.port = port;
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Syntax: java ChatServer <port-number>");
            System.exit(0);
        }

        int port = Integer.parseInt(args[0]);

        Server server = new Server(port);
        server.execute();
    }

    public void execute() {

        SSLServerSocketFactory sslServerSocketFactory =
                (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try ( ServerSocket sslServerSocket =
                      sslServerSocketFactory.createServerSocket(port)) {

            System.out.println("Chat Server is listening on port " + port);

            while (true) {
                Socket socket = sslServerSocket.accept();

                UserThread newUser = new UserThread(socket, this);
                userThreads.add(newUser);
                newUser.start();
            }

        } catch (IOException ex) {
            System.out.println("Error in the server: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    void broadcast(String message, UserThread excludeUser) {
        for (UserThread aUser : userThreads) {
            if (aUser != excludeUser) {
                aUser.sendMessage(message);
            }
        }
    }

    void printConnectedUserName(String userName) {
        System.out.println(userName+" connected");
    }

    void addUserName(String userName) {
        userNames.add(userName);
    }

    void removeUser(String userName, UserThread aUser) {
        boolean removed = userNames.remove(userName);
        if (removed) {
            userThreads.remove(aUser);
            System.out.println("The user " + userName + " quitted");
        }
    }

    Set<String> getUserNames() {
        return this.userNames;
    }

    boolean hasUsers() {
        return !this.userNames.isEmpty();
    }
}