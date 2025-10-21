package App.Exceptions;

public class ServiceFull extends RuntimeException {
    public ServiceFull(String message) {
        super(message);
    }
}
