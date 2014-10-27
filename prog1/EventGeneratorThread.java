import java.util.EventListener;
import java.util.Random;

public class EventGeneratorThread extends Thread {
    private WinnerEventListener[] listeners = new WinnerEventListener[0];
    
    public void addWinnerEventListener(WinnerEventListener t) {
        WinnerEventListener[] tmp = new WinnerEventListener[this.listeners.length+1];
        for (int i = 0; i < this.listeners.length; i++)
            tmp[i] = this.listeners[i];
        tmp[this.listeners.length] = t;
        this.listeners = tmp;
    }
    
    void fireWinnerEvent(WinnerEvent evt) throws WeveGotAWinnerException {
        System.out.println("Thread " + this.getName() + " has fired event");
        for (int i=0; i<this.listeners.length; i++) {
       //     try{
                
            this.listeners[i].simpleOccuranceEvent(evt);
      //  }
     //   catch(WeveGotAWinnerException exp){
   //     }
//
        }
    }
    
    
    
    
    
}