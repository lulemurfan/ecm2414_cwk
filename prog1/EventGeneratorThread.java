/**
 * EventGeneratorThread. This class runs as a thread and maintains an array of listeners waiting for a WinnerEvent. Furthermore, it fires off winner events
 * to the listeners. 
 * 
 * @author Christopher Frost/Iain Butler
 * @version 999.9
 */

//importing the EventListener and Random classes
import java.util.EventListener;
import java.util.Random;


/**
 * 
 */
public class EventGeneratorThread extends Thread {
    //create a WinnerEventListener array with name listeners
    private WinnerEventListener[] listeners = new WinnerEventListener[0];
    
    
    /**
     *  addWinnerEventListener adds the argument t (type WinnerEventListener) to the listeners array. It returns nothing as it is void. 
     *  
     */
    public void addWinnerEventListener(WinnerEventListener t) {
        WinnerEventListener[] tmp = new WinnerEventListener[this.listeners.length+1]; //creates a temporary array of listeners length +1
        for (int i = 0; i < this.listeners.length; i++) //for each index in the listeners array
            tmp[i] = this.listeners[i];  
        tmp[this.listeners.length] = t;
        this.listeners = tmp; //assigns the tmp array to listeners, making the listeners array one larger
    }
    
    /**
     * fireWinnerEvent fires the event passed to it in the argument, the event is of type WinnerEvent and is assigned to evt. Returns nothing as it's void.
     * Throws a WeveGotAWinnerException exception.
     * 
     */
    
    void fireWinnerEvent(WinnerEvent evt) throws WeveGotAWinnerException {
        for (int i=0; i<this.listeners.length; i++) { //for each listener index number in the listeners array
            this.listeners[i].simpleOccuranceEvent(evt); //call the simpleOccuranceEvent method on each listener
        }
    }
    
    
    
    
    
}