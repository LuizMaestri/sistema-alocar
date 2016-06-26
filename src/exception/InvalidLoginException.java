package exception;

/**
 * @author luiz
 * @version 1
 * @since 21/06/16
 */
public class InvalidLoginException extends Exception {
    public InvalidLoginException(String message) {
        super(message);
    }
}
