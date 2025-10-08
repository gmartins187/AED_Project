package Exceptions;

public class DoesNotExist extends RuntimeException {
    public DoesNotExist(String message) {
        super(message);
    }
}
