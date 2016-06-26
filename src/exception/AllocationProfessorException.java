package exception;

import classes.Classes;

/**
 * @author luiz
 * @version 1
 * @since 25/06/16
 */
public class AllocationProfessorException extends Exception {

    private Classes classes;

    public AllocationProfessorException(String message, Classes classes) {
        super(message);
        this.classes = classes;
    }

    @Override
    public String getMessage() {
        return String.format(
                super.getMessage(),
                classes.getClassNumber(),
                classes.getDiscipline().getId()
        );
    }
}
