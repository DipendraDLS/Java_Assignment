/*
    Q) Write a program to demonstrate encapsulation.
*/

package Q9_Encapsulation;

public class EncapsulationDemo
{

    public static void main(String[] args)
    {
        Student s = new Student();
        s.setRollno(16);
        s.setName("Dipendra");
        System.out.println("Roll no.: " + s. getRollno());
        System.out.println("Name: "+ s.getName());
    }
}
class Student
{
    private int rollno;
    private String name;

    public int getRollno()
    {
        return rollno;
    }

    public void setRollno(int rollno)
    {
        this.rollno = rollno;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
