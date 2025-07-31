package simple.library.rest.exception;

public class BookLoanException extends RuntimeException {
    public BookLoanException(String message) {
        super(message);
    }
}
