package q2_a_rmiclientcircle;
import compute.*;
import java.rmi.Naming;


public class RmiClientCircle 
{
       public static void main(String[] args)
       {
           try{
           String url = "rmi://127.0.0.1:8888/Compute";
           Compute compute = (Compute)Naming.lookup(url);
           double result = compute.calcArea(1);
           System.out.println("Area of Circle = "+ result);
       }
       catch(Exception e)
       {
           System.err.println("Remote exception:");
       }
       
       }
    
}
