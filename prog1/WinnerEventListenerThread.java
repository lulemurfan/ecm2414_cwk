/**
 * WinnerEventListenerThread, this is an implementation of WinnerEventListener and extends Thread. It 
 * throws WeveGotAWinnerException with the name of the winning player when specified event occurs.
 * 
 * @author Christopher Frost/Iain Butler
 * @version 999.9
 */

//imports the EventListener class
import java.util.EventListener;


public class WinnerEventListenerThread extends Thread implements WinnerEventListener {
    
    /**
     * This method throws a WeveGotAWinnerException. It takes argument WinnerEvent.
     * 
     */
    public void simpleOccuranceEvent(WinnerEvent evt) throws WeveGotAWinnerException{
        throw new WeveGotAWinnerException(((PebbleGame.Player)(Object)evt).getName()); 
        
        
    }
}
