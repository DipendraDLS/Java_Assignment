/*
Q2. Write a program to read records from a text file which contains people's name, principal,
    rate and time values. calculate the simple interest and write all the contents of the source file
    along with simple interest to destination file.

    Eg:-    source_simple_interest.txt
                John 1000   10.5    2.5
                Jane 5000   9.25    5.0
            destination.txt
                John 1000.00    10.50   2.50    2625.00
                Jane 1000.00    9.25    5.00    2312.50
*/
package Q3_SimpleInterest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SimpleInterest
{
    public static void main(String[] args) throws FileNotFoundException
    {

        Scanner in = new Scanner(new File("source_simple_interest.txt"));
        PrintWriter out = new PrintWriter(new File("destination_simple_interest.txt"));

        while (in.hasNext())
        {
            String name = in.next();
            float principal = in.nextFloat();
            float rate = in.nextFloat();
            float time = in.nextFloat();
            float result = principal * rate * time ;
            float interest = result/100;

            out.printf("%s %.2f %.2f %.2f %.2f %n",name, principal, rate, time, interest);
        }
        in.close();
        out.close();
    }

}