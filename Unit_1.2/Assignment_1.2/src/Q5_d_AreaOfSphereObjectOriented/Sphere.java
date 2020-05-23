/*
    Q) Write both procedural and object oriented programs to calculate the area of a
        a) Circle
        b) Square
        c) Rectangle
        d) Sphere
*/

package Q5_d_AreaOfSphereObjectOriented;

public class Sphere
{
    private double r;
    public Sphere(double r)
    {
        this.r = r;
    }

    public static void main(String[] args)
    {
        Sphere s = new Sphere(5);
        System.out.println("The area of Sphere with radius " + s.r + " is: "+ s.areaOfSphere());
    }
    public double areaOfSphere()
    {
        return 4*Math.PI*r*r;
    }

}
