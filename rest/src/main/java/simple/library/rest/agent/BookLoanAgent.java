package simple.library.rest.agent;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import simple.library.core.entity.BookCopy;
import simple.library.core.entity.BookLoan;
import simple.library.core.entity.Borrower;
import simple.library.core.modal.LoanStatus;
import simple.library.rest.converter.BookLoanConverter;
import simple.library.rest.modal.BookLoanDTO;
import simple.library.rest.modal.BookReturnDTO;
import simple.library.rest.modal.BookReturnResponseDTO;
import simple.library.rest.service.BookCopyService;
import simple.library.rest.service.BookLoanService;
import simple.library.rest.service.BorrowerService;
import simple.library.rest.validator.BookLoanValidator;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class BookLoanAgent {
    private final BookLoanConverter bookLoanConverter;
    private final BookLoanService bookLoanService;
    private final BookCopyService bookCopyService;
    private final BorrowerService borrowerService;
    private final BookLoanValidator bookLoanValidator;

    public ResponseEntity<?> loanBook(BookLoanDTO bookLoanDTO) {
        bookLoanValidator.validateBookLoan(bookLoanDTO);
        BookCopy bookCopy = bookCopyService.findByReference(bookLoanDTO.getBookReference());
        Borrower borrower = borrowerService.getBorrower(bookLoanDTO.getBorrowerReference());
        BookLoan bookLoan = bookLoanConverter.convert(bookCopy, borrower);
        Instant currentInstant = Instant.now();
        bookLoan.setBorrowedTime(currentInstant);
        bookLoan.setStatus(LoanStatus.BORROWED);
        bookLoan.setStatusTime(currentInstant);
        bookLoanService.save(bookLoan);
        return ResponseEntity.status(201).body("Book loan created for book ref:" + bookLoanDTO.getBookReference());
    }

    public ResponseEntity<?> returnBook(BookReturnDTO bookReturnDTO) {
        BookCopy bookCopy = bookCopyService.findByReference(bookReturnDTO.getBookReference());
        BookLoan bookLoan = bookLoanService.findByBook(bookCopy);
        bookLoan.setStatus(LoanStatus.RETURNED);
        bookLoan.setStatusTime(Instant.now());
        bookLoanService.save(bookLoan);
        return ResponseEntity
                .accepted()
                .body(BookReturnResponseDTO.builder()
                        .borrowerName(bookLoan.getBorrower().getName())
                        .borrowerReference(bookLoan.getBorrower().getReference())
                        .message("Book Loan marked as RETURNED for book ref: " + bookReturnDTO.getBookReference())
                        .build());
    }
}
