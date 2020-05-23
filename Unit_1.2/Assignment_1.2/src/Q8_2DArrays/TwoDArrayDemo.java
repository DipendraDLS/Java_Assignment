/*
    Q) Create a class with static methods to calculate the sum, difference and product of two matrices (represented by 2D arrays).
        The methods must return the resulting matrices.
*/
package Q8_2DArrays;

import java.util.Scanner;

public class TwoDArrayDemo
{
    public static void main(String[] args)
    {
        int [][] firstMatrix= new int[3][3];
        int [][] secondMatrix = new int[3][3];
        int [][] result = new int [3][3];

        Scanner in = new Scanner(System.in);
        //Taking input for 1st Matrix
        System.out.println("Enter values of first 3 by 3 matrix");
        for (int i =0 ; i<3; i++)
        {
            for (int j =0; j<3; j++)
            {
                firstMatrix[i][j] = in.nextInt();
            }
        }

        //Taking input for second Matrix
        System.out.println("Enter Values of second 3 by 3 matrix");
        for (int i =0 ; i<3; i++)
        {
            for (int j =0; j<3; j++)
            {
                secondMatrix[i][j] = in.nextInt();
            }
        }

        // Calling calculateSum, calculateDifference and calculateMultiply function.
         result = calculateSum(firstMatrix,secondMatrix);
         System.out.println("The result of Matrix addition is:");
         displayMatrix(result);

         result = calculateDifference(firstMatrix,secondMatrix);
         System.out.println("The result of difference between two matrices is:");
         displayMatrix(result);

         result=calculateProduct(firstMatrix,secondMatrix);
         System.out.println("The result of Matrix Multiplication is:");
         displayMatrix(result);
    }

    //calculates the sum between two matrices
    public static int[][] calculateSum(int [][]firstMatrix, int [][]secondMatrix)
    {
        int [][] sum = new int[3][3];

        for(int i = 0 ; i<3; i++)
        {
            for(int j =0; j<3; j++)
            {
                sum[i][j] = firstMatrix[i][j]+ secondMatrix[i][j];
            }
        }
        return sum;
    }

    //calculates the difference between two matrices
    public static int[][] calculateDifference(int [][]firstMatrix,int [][]secondMatrix)
    {
        int [][] difference = new int[3][3];

        for(int i = 0 ; i<3; i++)
        {
            for(int j =0; j<3; j++)
            {
                difference[i][j] = firstMatrix[i][j]-secondMatrix[i][j];
            }
        }
        return difference;
    }

    //calculates the product between two matrices
    public static int[][] calculateProduct(int[][] firstMatrix, int[][]secondMatrix)
    {
        int mul[][]=new int[3][3];

        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                mul[i][j]=0;
                for(int k=0;k<3;k++)
                {
                    mul[i][j]+=firstMatrix[i][k]*secondMatrix[k][j];
                }
            }
        }
        return mul;
    }

    //Display the result in a  Matrix form
    public static void displayMatrix(int [][] result)
    {
        for(int i = 0; i<3; i++)
        {
            for (int j = 0; j<3; j++)
            {
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
}
