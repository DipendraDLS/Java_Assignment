
/*
    Q) Write a program to read the contents of a file one line at a time and output them to the screen.
*/
package Q4_BufferReader;

import java.io.BufferedReader;
import java.io.FileReader;


public class BufferReaderDemo
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader in = null;

        try
        {
            in = new BufferedReader(new FileReader("source_BufferReader.txt"));
            String Line;
            while(true)
            {
                Line = in.readLine();
                if(Line == null)
                    break;
                System.out.println(Line);
            }
        }
        finally
        {
            if(in!= null)
                in.close();
        }
    }
}

