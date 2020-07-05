package q2_b_rmiclientrectangle;

import compute.Compute;
import java.rmi.Naming;

public class RmiClientRectangle 
{    
    public static void main(String[] args)
    {
        
           try{
           String url = "rmi://127.0.0.1:8888/Compute";
           Compute compute = (Compute)Naming.lookup(url);
           double result = compute.calcArea(5,6);
           System.out.println("Area of Rectangle= "+ result);
       }
       catch(Exception e)
       {
           System.err.println("Remote exception:");
       }
       
    }
    
}
