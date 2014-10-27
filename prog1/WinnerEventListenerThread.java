import java.util.EventListener;


public class WinnerEventListenerThread extends Thread implements WinnerEventListener {
    
    public void simpleOccuranceEvent(WinnerEvent evt) throws WeveGotAWinnerException{
        System.out.println("WinnerEventListener successfully called");
        ((PebbleGame.Player)(Object)evt).stop();
        System.out.println("WE'VE GOT A WINNNNERR");
        
        
        throw new WeveGotAWinnerException();
        
        
    }
}
