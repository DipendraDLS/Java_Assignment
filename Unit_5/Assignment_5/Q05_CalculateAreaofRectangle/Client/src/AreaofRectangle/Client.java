package AreaofRectangle;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Client
{
    public static void main(String[] args) throws IOException {
        final String HOST = "127.0.0.1";
        final int PORT = 1234;

        System.out.println("Client started.");
        try (
                Socket socket = new Socket(HOST, PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                Scanner in = new Scanner(socket.getInputStream());
                Scanner s = new Scanner(System.in);
        ) {
            while (true)
            {
                //*************************** For Calculating Radius ********************************************
                System.out.print("Enter length to calculate area of rectangle: ");
                double length = s.nextDouble();
                System.out.println("Enter breadth to calculate area of rectangle:");
                double breadth = s.nextDouble();
                out.println(length);
                out.println(breadth);

                System.out.println("Area of Rectangle returned from server: " + in.nextDouble());

                //****************** User Choice to exit program ***************************************************
                System.out.println("Do you want to exit?(Y/N):");
                String choice = s.next();
                out.println(choice);
                if(choice.equalsIgnoreCase("Y"))
                    break;
            }
        }
        System.out.println("Client has been stopped....");
    }
}