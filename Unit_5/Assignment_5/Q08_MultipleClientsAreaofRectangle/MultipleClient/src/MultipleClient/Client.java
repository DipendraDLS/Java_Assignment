package MultipleClient;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client
{
    public static void main(String[] args) throws Exception
    {
        final String HOST = "localhost";
        final int PORT = 1234;

        try (
                Socket socket = new Socket(HOST, PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                Scanner in = new Scanner(socket.getInputStream());
                Scanner s = new Scanner(System.in)
        ) {
            System.out.println("Client Started...");
            while (true)
            {
                //*************************** From Client to obtain Radius ********************************************
                System.out.print("Enter Length: ");
                double length = s.nextDouble();
                out.println(length);

                System.out.print("Enter Breadth: ");
                double breadth = s.nextDouble();
                out.println(breadth);

                System.out.println("Area of rectangle returned from server: " + in.nextDouble());


                System.out.println("Do you want to exit?(Y/N): ");
                String choice = s.next();
                out.println(choice);
                if(choice.equalsIgnoreCase("Y")) break;
            }
            System.out.println("Client stopped...");

        }
        catch (Exception e)
        {

        }

    }

}
