package q2_c_rmiclientsphere;

import compute.Compute;
import java.rmi.Naming;

public class RmiClientSphere
{
     public static void main(String[] args)
    {
           try{
           String url = "rmi://127.0.0.1:8888/Compute";
           Compute compute = (Compute)Naming.lookup(url);
           double result = compute.calcArea(1);
           System.out.println("Area of Sphere= "+ result);
       }
       catch(Exception e)
       {
           System.err.println("Remote exception:");
       }
       
    }
    
}
