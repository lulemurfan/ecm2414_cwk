
public class WhiteBag extends Bag
{
    private int[] pebbles;
    
    /**
     * Constructor for objects of class WhiteBag
     */
    public WhiteBag()
    {
        pebbles = new int[0];
    }


    public void addPebble(int peb)
    {
        int[] tmp = new int[pebbles.length+1];
        for (int i = 0; i < pebbles.length; i++)
            tmp[i] = pebbles[i];
        tmp[pebbles.length] = peb;
        pebbles = tmp;
    }
    public int[] takeBag()
    {
        int[] tmp = pebbles.clone();
        pebbles = new int[0];
        return tmp;
        
   }
}
