package exception;

/*
 * Name        : InvalidCalculationException
 * Date        : 2023-11-08
 * description : this class is used for processing exception that occur by calculating.
 */
public class InvalidCalculationException extends Exception
{
    public InvalidCalculationException(String message)
    {
        super(message);
    }
}
