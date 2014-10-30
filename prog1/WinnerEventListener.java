
import java.util.EventListener;

/**
 * An interface to provide functionality for the Event Listener object.
 */

// A class must implement this interface to handle WinnerEventListener.
public interface WinnerEventListener extends EventListener {
    public void simpleOccuranceEvent(WinnerEvent evt) throws WeveGotAWinnerException;
}

