package simple.library.core.entity;

import jakarta.persistence.*;
import lombok.Data;
import simple.library.core.modal.LoanStatus;

import java.time.Instant;

@Entity
@Table(name = "book_loan")
@Data
public class BookLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "borrower_id", referencedColumnName = "id")
    private Borrower borrower;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_copy_id", referencedColumnName = "id")
    private BookCopy bookCopy;
    @Column(name = "borrowed_time", nullable = false)
    private Instant borrowedTime;
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private LoanStatus status;
    @Column(name = "status_time", nullable = false)
    private Instant statusTime;
}

