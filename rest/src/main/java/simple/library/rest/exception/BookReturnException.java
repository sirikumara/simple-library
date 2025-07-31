package simple.library.rest.exception;

public class BookReturnException extends RuntimeException {
    public BookReturnException(String message) {
        super(message);
    }
}
