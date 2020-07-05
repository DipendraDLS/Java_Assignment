package q2_b_rmiserverrectangle;

import compute.Compute;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RmiServerRectangle implements Compute
{

    public RmiServerRectangle() {super();}
    public double calcArea (double l , double b) throws RemoteException
    {
        return l*b;
    }
  
    public static void main(String[] args) 
    {
        try
        {
            Compute server = new RmiServerRectangle();
            final int PORT = 8888;
            Registry registry = LocateRegistry.createRegistry(PORT);
            UnicastRemoteObject.exportObject(server,PORT);
            registry.rebind("Compute", server);

        }
        catch(Exception e)
        {
            System.err.println("RmiServer Exception.");
            
        }
    }
    
}
