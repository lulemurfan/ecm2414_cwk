import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
 
public class PlayerFile {
    private File file;
    public PlayerFile (int player)
    {
        try 
        {
            file = new File("player"+ String.valueOf(player) + "_output.txt");
            file.createNewFile(); //At the start of the program create a new file
        } catch (IOException e) {System.out.println("Error");}
    }
    
    public void write(String str)
    {
        try 
        {
 			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.append(str);
			bw.newLine();
			bw.close();
		} catch (IOException e) {}
    }
    
}