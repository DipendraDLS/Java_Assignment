/*
    Q) Write both procedural and object oriented programs to calculate the area of a
        a) Circle
        b) Square
        c) Rectangle
        d) Sphere
*/

package Q5_b_AreaOfSquareObjectOriented;

public class Square
{
    private double l;
    public Square(double l)
    {
        this.l = l;
    }

    public static void main(String[] args)
    {
        Square s = new Square(5);
        System.out.println("The area of Square with length "+ s.l + " is: "+ s.areaOfSquare());
    }

    public double areaOfSquare()
    {
        return l*l;
    }
}

