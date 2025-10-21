package App.Exceptions;

public class InvalidValue extends RuntimeException {
    public InvalidValue(String message) {
        super(message);
    }
}
