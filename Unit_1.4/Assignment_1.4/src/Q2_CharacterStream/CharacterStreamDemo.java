/*
    Q) Write a program to duplicate each character in a text file and write the output in a separate file using character stream.
        e.g.
            source.txt
               apple
            destination.txt
              aappppllee
 */

package Q2_CharacterStream;

import java.io.FileReader;
import java.io.FileWriter;

public class CharacterStreamDemo
{

    public static void main(String[] args) throws Exception
    {

        FileReader in = null;
        FileWriter out = null;

        in = new FileReader("source_character_stream.txt");
        out =new FileWriter("destination_character_stream.txt");

        int charData;
        while(true)
        {
            charData = in.read();
            if (charData == -1)
                break;
            else
            {
                out.write(charData);
                out.write(charData);
            }
        }
        if (in!= null)in.close();
        if (out!=null)out.close();
    }
}
