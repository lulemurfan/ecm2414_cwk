import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
public class BagFile {
    private FileReader fr;
    private File file;
    public BagFile (String filename)
    {
        try
        {
            file = new File(filename);
            fr = new FileReader(file.getAbsoluteFile());
        } catch (IOException e) {System.out.println("Error");}
    }
   
    public int[] getPebbles() throws IllegalFileFormatValueException{
 
        try 
        { 
            BufferedReader br = new BufferedReader(fr);
            String[] tmp = br.readLine().split(",");
            int[] temp = new int[tmp.length];


            for(int n = 0; n < tmp.length; n++) {
                temp[n] = Integer.parseInt(tmp[n]);
            }
            br.close();
            return temp;
        }
        catch (IOException e) {
            //throw new IllegalFileFormatValueException();
            return new int[0];
        }
        catch (NullPointerException e) {
            throw new IllegalFileFormatValueException();
        }
 
    }
}