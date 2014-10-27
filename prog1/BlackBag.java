import java.util.Arrays;
import java.util.Random;

public class BlackBag extends Bag
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
    
    public int takePebble() throws EmptyBagException{
    
        if (pebbles.length == 0 && corresponding.getLength() == 0) {
            throw new EmptyBagException();
        }          
            
        else {
            Random rand = new Random();
            int n = rand.nextInt(pebbles.length);
            int val = pebbles[n];
      
            int[] tmp = new int[pebbles.length-1];
            for (int i=0; i<n; i++)
                tmp[i] = pebbles[i];
            for (int i = n+1; i< pebbles.length; i++)
                tmp[i-1] = pebbles[i];
            pebbles = tmp;
            
            if (pebbles.length == 0)
                takeCorrespondingPebbles();
            
            return val;
        }
    }
    
   public int numberOfPebbles()
    {
        return pebbles.length;
    }

        /**
     * Will take an array of pebbles from a White bag
     * 
     */
    public void addPebbles(int[] peb)
    {
        pebbles = peb;
    }

    
   void makeArray(int[] a){
        int[] pebbles = new int[a.length];
        for(int i=0; i<a.length;i++){
            pebbles[i] = a[i];
        }
    }

        void putPebbleInWhite(int peb)
    {
        corresponding.addPebble(peb);
    }

        void takeCorrespondingPebbles()
    {   int[] a;
        a = corresponding.takeBag(this);
        //int[] pebbles = corresponding.takeBag(this);
    }
}
