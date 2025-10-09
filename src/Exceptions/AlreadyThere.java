package Exceptions;

public class AlreadyThere extends RuntimeException {
    public AlreadyThere(String message) {
        super(message);
    }
}
