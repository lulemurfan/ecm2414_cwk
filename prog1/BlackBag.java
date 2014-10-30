/**
 * The class BlackBag extends the abtract class Bag. It is used by the Player object when playing the pebble game
 * Includes methods to take pebbles from the bag, refill itself from the corresponding white bag and obtain the number of pebbles in a bag
 * 
 * @author Christopher Frost/Iain Butler
 * @version -1.9
 */

//import the Arrays and Random classes
import java.util.Arrays;
import java.util.Random;

public class BlackBag extends Bag
{
    //declare variables
    private WhiteBag corresponding;
    private int[] pebbles;
    private String bagName;

    /**
     * Constructor for objects of class BlackBag, arguments int[] peb (an integer array peb is used to populate the pebbles array), WhiteBag corres (used to allocate
     * the corresponding white bag), String bagName (to provide the bag with a name)
     */
    public BlackBag(int[] peb, WhiteBag corres, String bagName)
    {
        pebbles = peb;
        corresponding = corres;
        this.bagName = bagName;
    }

    
    /**
     * This method returns a random pebble from the black bag, a pebble is an integer. Also throws an EmptyBagException if the bag and the corresponding white
     * bag is empty. Has no arguments.
     * 
     */
    public int takePebble() throws EmptyBagException{
        
        
        if (pebbles.length == 0 && corresponding.getLength() == 0) { //if both bags are empty
            throw new EmptyBagException(); //throw exception
        }          

        else {
            Random rand = new Random(); //create new Random instance
            int n = rand.nextInt(pebbles.length); //generate random integer
            int val = pebbles[n];

            int[] tmp = new int[pebbles.length-1];  //create tmp array with -1 length of pebbles
            for (int i=0; i<n; i++)
                tmp[i] = pebbles[i]; //assign the tmp index to the corresponding pebbles value
            for (int i = n+1; i< pebbles.length; i++)
                tmp[i-1] = pebbles[i]; 
            pebbles = tmp; //reassign pebbles to reference tmp

            if (pebbles.length == 0) //if pebbles = empty
                takeCorrespondingPebbles(); //take white bag's pebbles

            return val; //return the random pebble taken
        }
    }
    
    /**
     * Returns the number of pebbles in the array pebbles
     */
    public int numberOfPebbles()
    {
        return pebbles.length;
    }

    /**
     * Sets the pebbles array to the new array of argument int[] peb.
     */
    public void addPebbles(int[] peb)
    {
        pebbles = peb;
    }

    /**
     * returns the name of the bag
     */
    public String getName(){
        return bagName;
    }
    /**
     * Makes a pebbles array of length and of reference to the int[] a argument
     */
    void makeArray(int[] a){
        int[] pebbles = new int[a.length];
        for(int i=0; i<a.length;i++){
            pebbles[i] = a[i];
        }
    }
    
    /**
     * Places a pebble into the white bag
     */

    void putPebbleInWhite(int peb)
    {
        corresponding.addPebble(peb);
    }

    /**
     * takes the white bag's pebbles
     */
    void takeCorrespondingPebbles()
    {   int[] a;
        a = corresponding.takeBag(this);
        //int[] pebbles = corresponding.takeBag(this);
    }
    
    public int[] seePeb()
    {
        return pebbles;
    }
}
