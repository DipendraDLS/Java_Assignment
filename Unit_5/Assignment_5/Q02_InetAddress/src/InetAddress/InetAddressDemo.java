package InetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo
{
        public static void main(String[] args)throws UnknownHostException
        {
            InetAddress address = InetAddress.getByName("www.google.com");
            System.out.println(address.getHostAddress());
            System.out.println(address.getHostName());
        }
}
