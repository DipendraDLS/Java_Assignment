/*
    Q) Write a program to input whole lines from the keyboard and write them to a file.
       Exit the program when the user types "quit"
*/

package Q5_WriteIntoFile;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class WriteIntoFile
{
    public static void main(String[] args) throws Exception
    {
        PrintWriter out = null;
    try {
        out = new PrintWriter(new FileWriter("destination_write_into_file.txt"));
        Scanner in = new Scanner(System.in);
        while (true)
        {
            System.out.println("Enter your Text:");
            String text = in.nextLine();
            if (text.equals("quit"))
                break;
            out.write(text);
            System.out.println(text);
        }
    }
    finally
    {
        if(out!= null) out.close();
    }
    }
}
