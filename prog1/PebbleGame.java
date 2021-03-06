import java.util.Random;
import java.util.Arrays;

/**
 * The PebbleGame, it creates X number of players (depending on the input at the terminal)
 */
public class PebbleGame
{
    /**
     * Player is the object which 'plays' the game, which runs on their own thread.
     */
    class Player extends Thread
    {
        private int[] hand = new int[9]; //Having a length of 9 stop the expansion/shrinking of the array
        private int playerID;
        private PlayerFile playerFile;
        private PebbleGame currentGame;

        public Player (int pID, PebbleGame outer) {
            playerID = pID;
            playerFile = new PlayerFile(playerID);
            currentGame = outer;
        }
        public void run()
        {
            System.out.println(Thread.currentThread().getName() + " started");
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
            
            BlackBag[] bags = currentGame.bagArray;
            for(int i=0;i<9;i++)
            {
                for(BlackBag bag : bags){

                    if(bag.numberOfPebbles() > largest){
                        largest =  bag.numberOfPebbles();
                        largeBag = bag;
                    }

                }
                System.out.println(largeBag);
                hand[i] = largeBag.takePebble();

            }    
        }
    }
    public static BlackBag[] bagArray = new BlackBag[3];
    public static EventGeneratorThread generatorThread;
    public static Player[] players;
    public static void main(String[] args)
    {
        WhiteBag A = new WhiteBag("A");
        WhiteBag B = new WhiteBag("B");
        WhiteBag C = new WhiteBag("C");
        int[] t1;
        int[] t2;
        int[] t3;

        try
        {
            t1 = (new BagFile(args[0])).getPebbles();
            t2 = (new BagFile(args[1])).getPebbles();
            t3 = (new BagFile(args[2])).getPebbles();
            int noOfPlayers = (new PebbleGame()).makePlayers(args[3]);

            if ((t1.length + t2.length + t3.length) < (9*noOfPlayers)) {
                System.out.println("You need to make sure that the number of pebbles is bigger than 9*no of players");
                System.exit(0);
            } 
            
            bagArray[0] = new BlackBag(t1,A, "X");
            bagArray[1] = new BlackBag(t2,B, "Y");
            bagArray[2] = new BlackBag(t3,C, "Z");
            
            EventGeneratorThread generatorThread = new EventGeneratorThread();
            generatorThread.start();
            System.out.println("Threads started");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("There wasn't enough arguments given, e.g file1.txt file2.txt file3.txt 7");
            System.exit(0);
        } catch (NullPointerException e) {
            System.out.println("There wasn't enough arguments given, e.g file1.txt file2.txt file3.txt 7");
            System.exit(0);
        } catch (IllegalPlayerNumberException e) {
            System.out.println("You entered the players incorrectly");
            System.exit(0);
        } catch (IllegalFileFormatValueException e) {
            System.out.println("The format of the input files are incorrect");
            System.exit(0);
        }
        for (int i=0; i < players.length; i++)
        {
            players[i].start();
        }
    }
    private int makePlayers(String noOfPlayers) throws IllegalPlayerNumberException
    {

        int noPlayers;
        try {
            noPlayers = Integer.parseInt(noOfPlayers);
            players = new Player[noPlayers];
        } catch (NumberFormatException e) {
            throw new IllegalPlayerNumberException();
        }
        if (noPlayers < 1) {
            throw new IllegalPlayerNumberException();
        }
        for (int i = 0; i < noPlayers; i++) {
            players[i] = new Player(i,this);
        }
        return noPlayers;
    }
}
