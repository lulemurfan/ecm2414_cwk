import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
 
public class BagFile {
    private FileReader fr;
    public BagFile (String filename)
    {
        try
        {
            fr = new FileReader(filename + ".txt");
        } catch (IOException e) {}
    }
   
    public int[] getPebbles() {
 
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
        catch (IOException e) {return new int[0];}
        catch (NullPointerException e) {return new int[0];}
 
    }
}