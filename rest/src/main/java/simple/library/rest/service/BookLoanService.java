package simple.library.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import simple.library.core.entity.BookCopy;
import simple.library.core.entity.BookLoan;
import simple.library.core.modal.LoanStatus;
import simple.library.core.repository.BookLoanRepository;
import simple.library.rest.exception.BookLoanException;

@Service
@RequiredArgsConstructor
public class BookLoanService {
    private final BookLoanRepository repository;

    public void save(BookLoan entity) {
        repository.save(entity);
    }

    public BookLoan findByBook(BookCopy bookCopy) {
        return repository.findByStatusAndBookCopy_Reference(LoanStatus.BORROWED, bookCopy.getReference())
                .orElseThrow(() -> new BookLoanException("No book loan found"));
    }

    public void isBorrowedAlready(String reference) {
        repository.findByStatusAndBookCopy_Reference(LoanStatus.BORROWED, reference)
                .ifPresent(bookLoan -> {
                    throw new BookLoanException("Book already borrowed and not returned yet.");
                });
    }
}
