
public class WhiteBag extends Bag
{
    private int[] pebbles;
    private int[] tmp;
    
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
    public int[] takeBag(BlackBag b)
    {
        int[] tmp = pebbles.clone();
        pebbles = new int[0];
        b.makeArray(tmp);
        
        return tmp;
        
   }
}
