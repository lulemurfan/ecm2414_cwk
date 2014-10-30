import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
/**
 * An object to handle all the dealings with the reading from the file of pebbles.
 */
public class BagFile {
    //Init the varibles used in this object
    private FileReader fr;
    private File file;
    /**
     * Constructor which stores sets the file name/location to be used in the object
     */
    public BagFile (String filename)
    {
        try
        {
            file = new File(filename);
            fr = new FileReader(file.getAbsoluteFile());
        } catch (IOException e) {System.out.println("Error");}
    }
   
    /**
     * This method gets the pebbles from the file and returns an array of pebbles
     */
    public int[] getPebbles() throws IllegalFileFormatValueException{
         try 
        { 
            BufferedReader br = new BufferedReader(fr);
            String[] tmp = br.readLine().split(","); //Make each number an element in the array
            int[] temp = new int[tmp.length];
            for(int n = 0; n < tmp.length; n++) {
                temp[n] = Integer.parseInt(tmp[n]);
            }
            br.close(); //Close the reader
            return temp;
        }
        catch (IOException e) {
            //An error will have already been printed to the screen
            return new int[0];
        }
        catch (NullPointerException e) {
            throw new IllegalFileFormatValueException();
        }
 
    }
}