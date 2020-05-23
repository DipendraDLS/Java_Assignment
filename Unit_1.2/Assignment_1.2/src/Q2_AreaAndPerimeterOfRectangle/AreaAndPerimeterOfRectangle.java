/*
2) Write an object oriented program to find area and perimeter of rectangle. [2073, 2074]
 */

package Q2_AreaAndPerimeterOfRectangle;
public class AreaAndPerimeterOfRectangle
{
    private double l,b;
    public AreaAndPerimeterOfRectangle(double l,double b)
    {
        this.l=l;
        this.b =b;
    }
    public static void main(String[] args)
    {
        AreaAndPerimeterOfRectangle r = new AreaAndPerimeterOfRectangle(5,10);
        System.out.println("The area of Rectangle with length " +r.l + " & breadth " + r.b +" is: " + r.areaOfRectangle());
        System.out.println("The perimeter of Rectangle with length " +r.l + " & breadth " + r.b +" is: " + r.perimeterOfRectangle());
    }
    public double areaOfRectangle()
    {
        return l*b;
    }
    public double perimeterOfRectangle()
    {
        return 2*(l+b);
    }
}



