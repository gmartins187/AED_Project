package Exceptions;

public class InvalidOrder extends RuntimeException {
    public InvalidOrder(String message) {
        super(message);
    }
}
