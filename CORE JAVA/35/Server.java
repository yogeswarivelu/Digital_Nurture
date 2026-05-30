import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {

        try {

            // Create Server Socket
            ServerSocket serverSocket = new ServerSocket(5000);

            System.out.println("Server is waiting for client connection...");

            // Accept Client Connection
            Socket socket = serverSocket.accept();

            System.out.println("Client Connected");

            // Input and Output Streams
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true);

            Scanner sc = new Scanner(System.in);

            String clientMessage;
            String serverMessage;

            while (true) {

                // Receive message from client
                clientMessage = in.readLine();

                System.out.println("Client: " + clientMessage);

                // Stop chat
                if (clientMessage.equalsIgnoreCase("exit")) {
                    break;
                }

                // Send message to client
                System.out.print("Server: ");
                serverMessage = sc.nextLine();

                out.println(serverMessage);

                if (serverMessage.equalsIgnoreCase("exit")) {
                    break;
                }
            }

            // Close Resources
            socket.close();
            serverSocket.close();
            sc.close();

            System.out.println("Chat Ended");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}