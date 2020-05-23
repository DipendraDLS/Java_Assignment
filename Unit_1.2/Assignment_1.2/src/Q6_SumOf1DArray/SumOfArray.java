/*
    Q) Write a static method to calculate the sum of a one dimensional array.
*/

package Q6_SumOf1DArray;

public class SumOfArray
{
    public static void main(String[] args)
    {
        int []a = {1,2,3,4,5};
        System.out.println("The sum of numbers in array is: "+ sum(a));
    }
    public static int sum(int []data)
    {
        int sum =0;
        for(int i = 0; i<data.length; i++)
        {
            sum +=data[i];
        }
        return sum;
    }
}
