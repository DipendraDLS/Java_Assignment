/*
    Q) Write a program to demonstrate try-finally.
 */

package Q2_TryFinally;

public class TryFinallyDemo
{
    public static void main(String[] args)
    {
        int[] arr = new int[4];
        try
        {
            int i = arr[3];
            System.out.println("Inside try block");
        }
        finally
        {
            System.out.println("Finally block executed.");
        }
    }
}
