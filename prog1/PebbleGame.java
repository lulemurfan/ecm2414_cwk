import java.util.Random;
/**
 * Write a description of class PebbleGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PebbleGame
{
    public static BlackBag[] bagArray;
    public static void main(String[] args)
    {
        WhiteBag A = new WhiteBag();
        WhiteBag B = new WhiteBag();
        WhiteBag C = new WhiteBag();
        int[] t1 = null;
        int[] t2 = null;
        int[] t3 = null;
        BlackBag[] bagArray = new BlackBag[3];
        bagArray[0] = new BlackBag(t1,A);
        bagArray[1] = new BlackBag(t2,B);
        bagArray[2] = new BlackBag(t3,C);
    }
    class Player extends Thread
    {
        private int[] hand = new int[9]; //Having a length of 9 stop the expansion/shrinking of the array
        public void run()
        {
            init();
            while(true)
            {
                Random rand = new Random();
                int n = rand.nextInt(PebbleGame.bagArray.length);
                int newPebble = PebbleGame.bagArray[n].takePebble();
                
                int weight = newPebble;
                for (int i : hand)
                    weight += i;
                if (weight == 100)
                    ;//event
                int a = rand.nextInt(10);
                if (a == 9) {
                    PebbleGame.bagArray[n].putPebbleInWhite(newPebble);
                } else {
                    PebbleGame.bagArray[n].putPebbleInWhite(hand[a]);
                    hand[a]=newPebble;
                }
            }
        }
        
        private void init()
        {
            int largest = Integer.MIN_VALUE;
            BlackBag largeBag = null;
            for(int i=0;i<10;i++)
            {
                for(BlackBag bag : PebbleGame.bagArray){
                    
                    if(bag.numberOfPebbles() > largest){
                        largest =  bag.numberOfPebbles();
                        largeBag = bag;
                    }
                    
                }
                hand[i] = largeBag.takePebble();
          
                    
                }    
                
            }
        }
    }

