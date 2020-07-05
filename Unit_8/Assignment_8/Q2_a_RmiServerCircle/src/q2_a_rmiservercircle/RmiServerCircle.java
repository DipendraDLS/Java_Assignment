package q2_a_rmiservercircle;

import compute.*;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RmiServerCircle implements Compute
{

    public RmiServerCircle() {super();}
    public double calcArea (double r) throws RemoteException
    {
        return Math.PI*r*r;
    }

    public static void main(String[] args) 
    {
        try
        {
            Compute server = (Compute) new RmiServerCircle();
            final int PORT = 8888;
            Registry registry = LocateRegistry.createRegistry(PORT);
            UnicastRemoteObject.exportObject(server,PORT);
            registry.rebind("Compute", server);

        }catch(Exception e)
        {
            System.err.println("RmiServer Exception.");
        }
    }   
}
