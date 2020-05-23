/*
    Q) Write both procedural and object oriented programs to calculate the area of a
        a) Circle
        b) Square
        c) Rectangle
        d) Sphere
*/

package Q5_c_AreaOfRectangleProcedural;

import java.util.Scanner;

public class Rectangle
{
    public static void main(String[] args)
    {
        System.out.println("Enter the length and breadth of rectangle: ");
        Scanner in = new Scanner(System.in);
        double length = in.nextDouble();
        double breadth = in.nextDouble();
        System.out.println("The area of Rectangle with length " +length + " and breadth " +breadth+ " is: "+
                            areaOfRectangle(length,breadth));
    }

    public static double areaOfRectangle(double l, double b)
    {
        return l*b;
    }
}

