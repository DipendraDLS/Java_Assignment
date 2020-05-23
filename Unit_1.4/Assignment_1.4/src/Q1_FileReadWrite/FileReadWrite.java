/*
    Q. 1)	Write the simple java program that reads data from one file and
            writes data to another file. [2070, 2071, 2073, 2074]
 */
package Q1_FileReadWrite;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileReadWrite
{
    public static void main(String[] args) throws Exception
    {
        FileInputStream in = null;
        FileOutputStream out = null;
        in = new FileInputStream("source_FileReadWrite.txt");
        out = new FileOutputStream("destination_FileReadWrite.txt");

        int byteData;
        while (true)
        {
            byteData = in.read();
            if (byteData == -1)
            {
                break;
            }
            out.write(byteData);
        }

        if (in!=null) in.close();
        if (out!=null)out.close();

    }
}
