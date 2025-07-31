package simple.library.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import simple.library.core.entity.BookLoan;
import simple.library.core.modal.LoanStatus;

import java.util.Optional;
import java.util.UUID;

public interface BookLoanRepository extends JpaRepository<BookLoan, UUID> {
    Optional<BookLoan> findByStatusAndBookCopy_Reference(LoanStatus status, String reference);
}
