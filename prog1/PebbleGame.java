import java.util.Random;
import java.util.Arrays;
/**
 * Write a description of class PebbleGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PebbleGame
{
    public static BlackBag[] bagArray;
    public static EventGeneratorThread generatorThread;
    public static Player[] players;
    public static void main(String[] args)
    {
        WhiteBag A = new WhiteBag("A");
        WhiteBag B = new WhiteBag("B");
        WhiteBag C = new WhiteBag("C");
        int[] t1 = null;
        int[] t2 = null;
        int[] t3 = null;
        BlackBag[] bagArray = new BlackBag[3];
        bagArray[0] = new BlackBag(t1,A, "X");
        bagArray[1] = new BlackBag(t2,B, "Y");
        bagArray[2] = new BlackBag(t3,C, "Z");
        EventGeneratorThread generatorThread = new EventGeneratorThread();
        generatorThread.start();
        
    }
    class Player extends Thread
    {
        private int[] hand = new int[9]; //Having a length of 9 stop the expansion/shrinking of the array
        private int playerID = (int) Thread.currentThread().getId();
        private PlayerFile playerFile = new PlayerFile(playerID);
       
        
        public void run()
        {
            try{
                init();
            }
           catch(EmptyBagException e){
                System.out.println("EmptyBagException, this probably shouldn't happen");
                System.exit(0);
            }
            try{ 
                while(true)
                {
                    Random rand = new Random();
                    int n = rand.nextInt(PebbleGame.bagArray.length);
                    int newPebble = PebbleGame.bagArray[n].takePebble();
                    playerFile.write("player"+playerID+" has drawn a "+newPebble+" from bag"+PebbleGame.bagArray[n].getName());
                    playerFile.write("player"+playerID+" hand is "+ Arrays.toString(hand)+ newPebble);
                    
                    int weight = newPebble;
                    for (int i : hand)
                        weight += i;
                    if (weight == 100){
                        PebbleGame.generatorThread.fireWinnerEvent(new WinnerEvent(this));
                    //    playerFile.write("player"+playerID+"has won");
                        
                    }
                    int a = rand.nextInt(10);
                    if (a == 9) {
                        PebbleGame.bagArray[n].putPebbleInWhite(newPebble);
                        playerFile.write("player"+playerID+" has discarded a " + newPebble + " to bag"+PebbleGame.bagArray[n].getName());
                    } else {
                        PebbleGame.bagArray[n].putPebbleInWhite(hand[a]);
                        playerFile.write("player"+playerID+" has discarded a " + hand[a] + " to bag"+PebbleGame.bagArray[n].getName());
                        hand[a]=newPebble;
                    }
                    playerFile.write("player"+playerID+" hand is "+ Arrays.toString(hand)+ newPebble);
                }
            }
            catch(WeveGotAWinnerException winnerEvt){
                if(winnerEvt.name == this.getName()){
                    playerFile.write("player"+playerID+"has won");
                }
                else{
                    playerFile.write("player "+playerID+" has lost, "+"as "+winnerEvt.name+" has won");
                }
                
                String PebbleGameWinner = winnerEvt.name;
                System.out.println("Exception");
                
                
            }
            catch(EmptyBagException emptyBag){
                System.out.println("Yo Jonathan it seems yo test work'd");
                System.exit(0);
            }
            
            


        }
    

        private void init() throws EmptyBagException {
            
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

