/*
    Q) Write a program to demonstrate try-catch-finally.
 */


package Q1_TryCatchFinally;

import java.util.Scanner;

class InvalidRadiusException extends Exception
{
    public InvalidRadiusException(String message)
    {
        super(message);
    }
}
class Circle
{
    private double r;
    public void setR(double r) throws InvalidRadiusException
    {
        if(r<0)
        {
            throw new   InvalidRadiusException("Invalid radius as it can't be negative value. ");
        }
        else
        {
            this.r = r;
        }
    }
}

public class TryCatchFinallyDemo
{
    public static void main(String[] args)
    {
        System.out.println("Enter the radius: ");
        Scanner in = new Scanner(System.in);
        double radius = in.nextDouble();
        Circle c = new Circle();
        try
        {
            c.setR(radius);
        }
        catch (InvalidRadiusException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            System.out.println("Finally block executed");
        }
    }
}
