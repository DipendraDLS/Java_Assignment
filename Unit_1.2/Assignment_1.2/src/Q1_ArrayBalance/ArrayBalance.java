/*
1)	An array is called balanced if it’s even numbered elements (a[0], a[2], etc.) are even and its odd
    numbered elements (a[1], a[3], etc.) are odd. Write a function named balanced that accepts an array
    of integers which returns 1 if the array is balanced and returns 0 otherwise. [2075]
    	Elaboration of question,
         Examples:
        {2, 3, 6, 7} is balanced since a[0] and a[2] are even, a[1] and a[3] are odd.
        {6, 7, 2, 3, 12} is balanced since a[0], a[2] and a[4] are even, a[1] and a[3] are odd.
         {7, 15, 2, 3} is not balanced since a[0] is odd.
 */

package Q1_ArrayBalance;
public class ArrayBalance
{
    static int[] array = {6, 7, 2, 3, 12};

    public static void main(String[] arr)
    {
        System.out.println(isBalanced(array));
    }

    public static int isBalanced(int[] a)
    {
        int count = 1;
        for(int i = 0; i<array.length; i+=2)
        {
            if(a[i]%2 != 0)
            {
                count = 0;
                break;
            }
        }
        for(int j = 1;j< array.length; j+=2 )
        {
            if(a[j]%2 == 0)
            {
                count = 0;
                break;
            }
        }
        return count;
    }
}
