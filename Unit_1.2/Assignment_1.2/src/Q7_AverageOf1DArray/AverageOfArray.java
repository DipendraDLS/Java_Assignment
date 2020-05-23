/*
 Q) Write a static method to calculate the average of a one dimensional array.
*/
package Q7_AverageOf1DArray;

public class AverageOfArray
{
    public static void main(String[] args)
    {
        int []a = {1,2,3,4,5};
        System.out.println("The average of numbers in array is: "+ average(a));
    }

    public static int average(int []data)
    {

        int sum =0;
        for(int i = 0; i<data.length; i++)
        {
            sum +=data[i];
        }
        return sum/data.length;
    }
}
