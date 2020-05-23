package Q3_AddTwoNumbers;
import java.util.Scanner;

public class AddTwoNumbers
{
        public static void main(String[] args)
        {
            System.out.println("Enter two numbers to get sum:");
            Scanner in = new Scanner(System.in);
            double num1= in.nextDouble();
            double num2= in.nextDouble();

            System.out.println("The sum of "+ num1 +" and "+ num2
                    + " is: "+
                    sumOfTwoNumbers(num1,num2));
        }

        public static double sumOfTwoNumbers(double num1,double
                num2)
        {
            return num1+num2;
        }

}

