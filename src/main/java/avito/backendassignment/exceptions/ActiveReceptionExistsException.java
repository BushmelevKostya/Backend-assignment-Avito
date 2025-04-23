package avito.backendassignment.exceptions;

public class ActiveReceptionExistsException extends RuntimeException {
    public ActiveReceptionExistsException(String message) {
        super(message);
    }
}