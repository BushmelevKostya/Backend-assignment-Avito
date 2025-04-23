package avito.backendassignment.exceptions;

public class NoActiveReceptionException extends RuntimeException {
    public NoActiveReceptionException(String message) {
        super(message);
    }
}