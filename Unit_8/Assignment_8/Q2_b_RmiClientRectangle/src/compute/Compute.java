
package compute;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Compute extends Remote
{
    public double calcArea(double l , double b) 
            throws RemoteException;
    
    
}
