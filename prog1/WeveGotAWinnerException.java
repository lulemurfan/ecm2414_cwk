public class WeveGotAWinnerException extends Exception
{
    public String name;
    public WeveGotAWinnerException()
    {
        super();
    }
    
    public WeveGotAWinnerException(String throwingName){
        name = throwingName;
    }
    
}