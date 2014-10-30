import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
/**
 * Object to deal with writing to the player output files
 */
public class PlayerFile {
    private File file;
    
    /**
     * Constructor of the player file which sets up the file and the location
     */
    public PlayerFile (int player)
    {
        try 
        {
            file = new File("player"+ String.valueOf(player) + "_output.txt");
            //At the start of the program create a new file
            (new BufferedWriter(new FileWriter(file.getAbsoluteFile()))).write("");        
        } catch (IOException e) {System.out.println("Error");}
    }
    
    /**
     * Method to write a new line to file each time with the given input string
     */
    public void write(String str)
    {
        try 
        {
 			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true); //,
			BufferedWriter bw = new BufferedWriter(fw);
			bw.append(str);
			bw.newLine();
			bw.close();
		} catch (IOException e) {}
    }
    
}