package exception;

import classes.Classes;

/**
 * Created by loja on 25/06/2016.
 */
public class AllocationProfessorException extends Exception {

    Classes classes;

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
