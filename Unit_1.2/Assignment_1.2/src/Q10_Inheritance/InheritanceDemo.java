package Q10_Inheritance;

public class InheritanceDemo
{
    public static void main(String[] args)
    {
        Polygon pol =new Polygon();
        Rectangle rec = new Rectangle();
        Triangle tri = new Triangle();

        rec. setValues(10,10);
        System.out.println("Rec: "+rec.areaOfRectangel());

        tri.setValues(10, 10);
        System.out.println("Tri: "+ tri.areaOfTriangle());
    }
}

class Polygon
{
    protected int width ;
    protected int height;

    protected void setValues(int a, int b)
    {
        width = a;
        height = b;
    }
}

class Rectangle  extends Polygon
{
    int areaOfRectangel()
    {
        return (width*height);
    }
}

class Triangle extends Polygon
{
    double areaOfTriangle()
    {
        return (width*height)/2;
    }
}

