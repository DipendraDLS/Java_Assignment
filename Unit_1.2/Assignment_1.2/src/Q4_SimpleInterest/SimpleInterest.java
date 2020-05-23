package Q4_SimpleInterest;
import java.util.Scanner;
public class SimpleInterest
{
    public static void main(String[] args)
    {
        System.out.println("Enter Principle, Time & Rate:");
        Scanner in = new Scanner(System.in);
        double p = in.nextDouble();
        double t = in.nextDouble();
        double r = in.nextDouble();

        System.out.println("SimpleInterest = " +
                simpleInterestCalc(p,t,r));
    }
    public static double simpleInterestCalc(double p,
                                            double t,
                                            double r)
    {
        return (p*t*r)/100;
    }

}
