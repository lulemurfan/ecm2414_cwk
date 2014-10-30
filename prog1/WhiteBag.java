/**
 * Details the bevahour of the white bag in the system
 */
public class WhiteBag extends Bag
{
    //Init varibles to be used in the object
    private int[] pebbles;
    private int[] tmp;
    private String bagName;
    
    /**
     * Constructor for objects of class WhiteBag which stores the bag name
     */
    public WhiteBag(String bagName)
    {
        pebbles = new int[0];
        this.bagName = bagName;
    }

    /**
     * A method to add a single pebble to the white bag.
     */
    public synchronized void addPebble(int peb)
    {
        int[] tmp = new int[pebbles.length+1];
        for (int i = 0; i < pebbles.length; i++)
            tmp[i] = pebbles[i];
        tmp[pebbles.length] = peb;
        pebbles = tmp;
    }
    
    /**
     * A method which is called by BlackBag to return the whole object and set the bag as empty.
     */
    public synchronized int[] takeBag(BlackBag b)
    {
        int[] tmp = pebbles.clone(); //Make a deep copy
        pebbles = new int[0]; //Set the bag of pebbles as empty
        b.makeArray(tmp);
        return tmp; //Return array of pebbles
    }
   
    /**
     * Method to return the bag name
     */
   public String getName(){
        return bagName;
    }
   
    /**
     * Method to return the length of the bag
     */
   public int getLength(){
       return pebbles.length;
    }
    
   
}
