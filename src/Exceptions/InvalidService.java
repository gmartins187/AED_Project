package Exceptions;

public class InvalidService extends RuntimeException {
    public InvalidService(String message) {
        super(message);
    }
}
