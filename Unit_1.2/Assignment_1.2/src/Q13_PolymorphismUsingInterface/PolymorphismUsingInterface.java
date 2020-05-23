/*
    Q) Write a program to demonstrate polymorphism using interface as parent.
 */
package Q13_PolymorphismUsingInterface;

interface Shape
{
    double area();
}

class Square implements Shape
{
    public double l;
    public Square(double l)
    {
        this.l = l;
    }
    @Override
    public double area()
    {
        return l * l;
    }
}

class Circle implements Shape
{
    public double r;
    public Circle(double r)
    {
        this.r = r;
    }
    @Override
    public double area()
    {
        return Math.PI * r * r;
    }
}

public class PolymorphismUsingInterface
{
    public static void main(String[] args)
    {
        Shape[] shapes = new Shape[]
                {
                    new Square(5),
                    new Circle(1),
                    new Square(10),
                    new Circle(2)
                };
        for(Shape s : shapes)
            System.out.println(s.area());
    }
}
