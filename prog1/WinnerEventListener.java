
import java.util.EventListener;


// A class must implement this interface to handle WinnerEventListener.
public interface WinnerEventListener extends EventListener {
    public void simpleOccuranceEvent(WinnerEvent evt) throws WeveGotAWinnerException;
}

