package EchoServer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        final int PORT = 1234;
        System.out.println("Server started.");
        System.out.println("Listening to client...");

        try (
                ServerSocket serverSocket = new ServerSocket(PORT);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                Scanner in = new Scanner(clientSocket.getInputStream());
        ) {
            while (true) {
                String input = in.nextLine();
                if (input.equalsIgnoreCase("exit")) break;
                System.out.println("Received from client: " + input);

                out.println(input);
            }
        }

        System.out.println("Server stopped");
    }
}