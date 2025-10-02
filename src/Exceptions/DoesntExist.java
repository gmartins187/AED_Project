package Exceptions;

public class DoesntExist extends RuntimeException {
    public DoesntExist(String message) {
        super(message);
    }
}
