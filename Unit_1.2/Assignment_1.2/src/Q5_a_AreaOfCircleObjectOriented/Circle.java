/*
    Q) Write both procedural and object oriented programs to calculate the area of a
        a) Circle
        b) Square
        c) Rectangle
        d) Sphere
*/
package Q5_a_AreaOfCircleObjectOriented;

public class Circle
{
    private double r;
    public Circle(double r)
    {
        this.r=r;
    }

    public static void main(String[] args)
    {
        Circle c = new Circle(5);
        System.out.println("The area of Circle with radius "+ c.r + " is:" + c.areaOfSquare());
    }

    public double areaOfSquare()
    {
        return Math.PI*r*r;
    }



}
