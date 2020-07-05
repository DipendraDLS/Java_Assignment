package compute;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Compute extends Remote
{
    public double add(double a, double b) 
            throws RemoteException;
    
}
