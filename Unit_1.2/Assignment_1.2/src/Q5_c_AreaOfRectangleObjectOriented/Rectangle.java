/*
    Q) Write both procedural and object oriented programs to calculate the area of a
        a) Circle
        b) Square
        c) Rectangle
        d) Sphere
*/
package Q5_c_AreaOfRectangleObjectOriented;

public class Rectangle
{
    private double l,b;
    public Rectangle(double l,double b)
    {
        this.l=l;
        this.b =b;
    }



    public static void main(String[] args)
    {
        Rectangle r = new Rectangle(5,10);
        System.out.println("The area of Rectangle with length " +r.l + " & breadth " + r.b +" is: " + r.areaOfRectangle());
    }

    public double areaOfRectangle()
    {
        return l*b;
    }
}

