package devx.arjun.ProductServiceAPI.exception;

public class GenericExceptionHandler extends RuntimeException {
    public GenericExceptionHandler() {

    }

    public GenericExceptionHandler(String message) {
        super(message);
    }
}
