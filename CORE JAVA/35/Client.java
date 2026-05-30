import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        try {

            // Connect to Server
            Socket socket = new Socket("localhost", 5000);

            System.out.println("Connected to Server");

            // Input and Output Streams
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true);

            Scanner sc = new Scanner(System.in);

            String clientMessage;
            String serverMessage;

            while (true) {

                // Send message to server
                System.out.print("Client: ");
                clientMessage = sc.nextLine();

                out.println(clientMessage);

                if (clientMessage.equalsIgnoreCase("exit")) {
                    break;
                }

                // Receive reply from server
                serverMessage = in.readLine();

                System.out.println("Server: " + serverMessage);

                if (serverMessage.equalsIgnoreCase("exit")) {
                    break;
                }
            }

            // Close Resources
            socket.close();
            sc.close();

            System.out.println("Chat Ended");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}