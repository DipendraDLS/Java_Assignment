/*
    Q) Write both procedural and object oriented programs to calculate the area of a
        a) Circle
        b) Square
        c) Rectangle
        d) Sphere
*/

package Q5_d_AreaOfSphereProcedural;

import java.util.Scanner;

public class Sphere
{
    public static void main(String[] args)
    {
        System.out.println("Enter the radius of Sphere: ");
        Scanner in = new Scanner(System.in);
        double radius = in.nextDouble();
        System.out.println("The area of Sphere with radius " + radius + " is: "+ areaOfSphere(radius));
    }
    public static double areaOfSphere(double r)
    {
        return 4*Math.PI*r*r;
    }
}
