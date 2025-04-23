package avito.backendassignment.exceptions;

public class PvzNotFoundException extends RuntimeException {
    public PvzNotFoundException(String message) {
        super(message);
    }
}