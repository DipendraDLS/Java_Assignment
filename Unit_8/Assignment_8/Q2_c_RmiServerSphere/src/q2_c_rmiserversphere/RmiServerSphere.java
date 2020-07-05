package q2_c_rmiserversphere;
 
import compute.Compute;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RmiServerSphere implements Compute
{
    public RmiServerSphere() {super();}
    public double calcArea (double r) throws RemoteException
    {
        return 4*Math.PI*Math.pow(r, 2);
    }
  
    public static void main(String[] args) 
    {
        try
        {
            Compute server = new RmiServerSphere();
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
