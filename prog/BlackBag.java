
/**
 * Write a description of class BlackBag here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlackBag
{
    private WhiteBag corresponding;
    private int[] pebbles;
    
    /**
     * Constructor for objects of class BlackBag
     */
    public BlackBag(int[] peb, WhiteBag corres)
    {
        pebbles = peb;
        corresponding = corres;
    }

    public int takePebble()
    {
        return 0;
    }
    /**
     * Will take an array of pebbles from a White bag
     * 
     */
    public void addPebbles(int[] peb)
    {
        pebbles = peb;
    }
}
