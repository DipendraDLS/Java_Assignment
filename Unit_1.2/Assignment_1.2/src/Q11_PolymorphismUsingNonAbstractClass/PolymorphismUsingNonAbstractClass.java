/*
    Q) Write a program to demonstrate polymorphism using non-abstract class as parent.
*/
package Q11_PolymorphismUsingNonAbstractClass;

class Shape
{
    public double area()
    {
        return 0;
    }
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

public class PolymorphismUsingNonAbstractClass
{
    public static void main(String[] args)
    {
        Shape s =new Square(5);
        System.out.println("Area od Square: " + s.area());
    }
}
