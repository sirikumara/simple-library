package simple.library.rest.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import simple.library.rest.exception.BookReturnException;
import simple.library.rest.modal.BookLoanDTO;
import simple.library.rest.service.BookLoanService;

@Component
@RequiredArgsConstructor
public class BookLoanValidator {

    private final BookLoanService bookLoanService;

    public void validateBookLoan(BookLoanDTO bookLoanDTO) {
        bookLoanService.isBorrowedAlready(bookLoanDTO.getBookReference());
    }

    public void validateBookReturn(BookLoanDTO bookLoanDTO) {
        if (bookLoanDTO.getBookReference() == null
                || bookLoanDTO.getBookReference().trim().isEmpty()){
            throw new BookReturnException("Book reference is required");
        }
    }
}
