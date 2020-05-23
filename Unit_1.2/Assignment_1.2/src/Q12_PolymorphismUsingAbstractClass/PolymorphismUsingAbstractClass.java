/*
    Q) Write a program to demonstrate polymorphism using abstract class as parent.
*/

package Q12_PolymorphismUsingAbstractClass;

abstract class Shape
{
    public abstract double area();
}

class Square extends Shape
{
    private double l;
    public Square(double l)
    {
        this.l = l;
    }
    public double area()
    {
        return l*l;
    }
}

public class PolymorphismUsingAbstractClass
{
    public static void main(String[] args)
    {
        Shape s = new Square(5);
        System.out.println("Area of Squeare: "+s.area());
    }
}
