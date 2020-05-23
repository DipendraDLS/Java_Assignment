/*
    Q) Write both procedural and object oriented programs to calculate the area of a
        a) Circle
        b) Square
        c) Rectangle
        d) Sphere
*/

package Q5_b_AreaOfSquareProcedural;

import java.util.Scanner;

public class Square
{
    public static void main(String[] args)
    {
        System.out.println("Enter the length of Square: ");
        Scanner in = new Scanner(System.in);
        double length = in.nextDouble();
        System.out.println("The area of Square with " + length + " is: "+ areaOfSquare(length));
    }
    public static double areaOfSquare(double l)
    {
        return l*l;
    }
}
