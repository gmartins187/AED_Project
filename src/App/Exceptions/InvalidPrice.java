package App.Exceptions;

public class InvalidPrice extends RuntimeException {
    public InvalidPrice(String message) {
        super(message);
    }
}
