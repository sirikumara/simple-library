package simple.library.rest.converter;

import org.springframework.stereotype.Component;
import simple.library.core.entity.BookCopy;
import simple.library.core.entity.BookLoan;
import simple.library.core.entity.Borrower;

@Component
public class BookLoanConverter {
    public BookLoan convert(BookCopy bookCopy, Borrower borrower) {
        BookLoan entity = new BookLoan();
        entity.setBorrower(borrower);
        entity.setBookCopy(bookCopy);
        return entity;
    }
}
