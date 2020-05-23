/*
    Q) Write a program to create two classes Circle and Square, with appropriate fields and methods, in a package name shape.
       Create a separate class ShapeDemo to test the classes.
 */

package Q14_ShapeDemo;

class Circle
{
    private double radius;

    public double getRadius()
    {
        return radius;
    }

    public void setRadius(double radius)
    {
        this.radius = radius;
    }
    public double areaOfCircle()
    {
        return Math.PI*radius*radius;
    }
}

class Square
{
    private double length;

    public double getLength()
    {
        return length;
    }

    public void setLength(double length)
    {
        this.length = length;
    }
    public double areaOfSquare()
    {
        return length*length;
    }
}

public class ShapeDemo
{
    public static void main(String[] args)
    {
        Circle c = new Circle();
        Square s = new Square();
        c.setRadius(5);
        s.setLength(5);

        System.out.println("The area of Circle with radius " + c.getRadius() + " is: "+ c.areaOfCircle());
        System.out.println("The area of Square with length" + s.getLength() + " is: "+ s.areaOfSquare());

    }
}
