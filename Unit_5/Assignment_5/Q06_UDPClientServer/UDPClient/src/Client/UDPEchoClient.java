package Client;
import java.net.*;
import java.io.*;
public class UDPEchoClient
{
    public static void main(String[] args) throws Exception
    {
        InetAddress address = null;
        int port = 8000;         //Port for server to be created.
        DatagramSocket datagramSocket = null;
        BufferedReader keyboardReader = null;

        // Create a Datagram Socket...
        try
        {
            address = InetAddress.getByName("127.0.0.1");
            datagramSocket = new DatagramSocket();
            keyboardReader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Client Started...");

            String input;
            while (true)
            {
                System.out.println("Enter Input: ");
                // read input from the keyboard
                input = keyboardReader.readLine();

                // send datagram packet to the server
                DatagramPacket sendDatagramPacket = new DatagramPacket(input.getBytes(), input.length(), address, port);
                datagramSocket.send(sendDatagramPacket);

                //Receive datagram packet from server
                byte[] b1 = new byte[1024];
                DatagramPacket receiveDatagramPacket = new DatagramPacket(input.getBytes(),input.length());
                datagramSocket.receive(receiveDatagramPacket);

                String str = new String(receiveDatagramPacket.getData());
                System.out.println("Result Received from Server is: " + str);

                if (input.equalsIgnoreCase("exit")) break;
            }
            System.out.println("Client Stopped...");
        }
        catch (IOException e)
        {
            System.out.println(e);
            System.exit(1);
        }
    }
}