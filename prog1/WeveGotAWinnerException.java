/**
 * WeveGotAWinnerException. Exception to hold information regarding the winner of the game.
 * 
 * @author Christopher Frost/Iain Butler
 * @version 999.9
 */

public class WeveGotAWinnerException extends Exception
{
    public String name; //declaring the variable name
    
    public WeveGotAWinnerException()
    {
        super(); 
    }
    
    /**
     * Overloaded constructor with argument String throwingName, used to pass the name of the
     * winner into the exception
     * @overloaded
     * 
     */
    public WeveGotAWinnerException(String throwingName){
        name = throwingName; //assigns the name of the winner to the variable name
    }
    
}