import java.util.EventListener;


public class WinnerEventListenerThread extends Thread implements WinnerEventListener {
    
    public void simpleOccuranceEvent(WinnerEvent evt) throws WeveGotAWinnerException{
        System.out.println("WinnerEventListener successfully called");
        System.out.println("WE'VE GOT A WINNNNERR");
        throw new WeveGotAWinnerException(((PebbleGame.Player)(Object)evt).getName());
        
        
    }
}
