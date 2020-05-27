package ServerSide;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server
{

    public static void main(String[] args) throws Exception
    {
        final int PORT = 1234;
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server Started...");

        while(true)

        {
            Socket clientSocket = serverSocket.accept();
            Thread t = new Thread()
            {
                public void run()
                {
                    try (

                            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                            Scanner in = new Scanner(clientSocket.getInputStream());
                    )
                    {
                        while (true)
                        {
                            double radius = in.nextDouble();
                            double area = Math.PI*radius*radius;
                            System.out.println("Radius received from client: " + radius);
                            out.println(area);

                            //We must handle the 'choice' input of client as well if not then NosuchElement error occurs
                            String choice = in.next();
                            if (choice.equalsIgnoreCase("Y"))
                                break;

                        }
                    }
                    catch (IOException e)
                    {
                    }
                }
            };
            t.start();
        }
    }

}
