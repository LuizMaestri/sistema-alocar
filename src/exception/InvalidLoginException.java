package exception;

/**
 * @author luiz-maestri
 *         21/06/16.
 */
public class InvalidLoginException extends Exception {
    public InvalidLoginException(String message) {
        super(message);
    }
}
