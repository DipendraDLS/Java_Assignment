/*
    Q) Write both procedural and object oriented programs to calculate the area of a
        a) Circle
        b) Square
        c) Rectangle
        d) Sphere
*/
package Q5_a_AreaOfCircleProcedural;

import java.util.Scanner;

public class Circle
{
    public static void main(String[] args)
    {
        System.out.println("Enter the radius of a circle:");
        Scanner in = new Scanner(System.in);
        double radius = in.nextDouble();
        System.out.println("The area of a Circle with " + radius + " is: "+ areaOfCircle(radius));
    }

    public static double areaOfCircle(double r)
    {
        return Math.PI*r*r;
    }


}
