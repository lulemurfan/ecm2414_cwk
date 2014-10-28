/**
 * This is the WinnerEvent, it provides a call to the object that called it so that this is accessible. 
 * 
 * 
 * @author Christopher Frost/Iain Butler
 * @version 999.9
 */

//imports the EventObject class
import java.util.EventObject;


public class WinnerEvent extends EventObject 
{
    /**
     * Constructs the object with the Object that calls it being also placed inside
     */
    public WinnerEvent(Object source) {
        super(source);
    }
}