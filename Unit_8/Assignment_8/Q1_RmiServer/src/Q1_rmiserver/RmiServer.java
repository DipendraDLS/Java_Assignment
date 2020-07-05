package Q1_rmiserver;
import compute.*;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;



public class RmiServer implements Compute
{
    public RmiServer() {super();}
    public double add (double a , double b) throws RemoteException
    {
        return a+b;
    }
        
    public static void main(String[] args) 
    {
        try
        {
            Compute server = new RmiServer();
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
