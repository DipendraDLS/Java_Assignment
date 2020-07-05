package Q1_rmiclient;

import compute.*;
import java.rmi.Naming;

public class RmiClient 
{

 
    public static void main(String[] args) 
    {
       try{
           String url = "rmi://127.0.0.1:8888/Compute";
           Compute compute = (Compute)Naming.lookup(url);
           double result = compute.add(5,6);
           System.out.println("Sum = "+ result);
       }
       catch(Exception e)
       {
           System.err.println("Remote exception:");
       }
    }
    
}
