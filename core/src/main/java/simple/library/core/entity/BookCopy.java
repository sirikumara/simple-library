package simple.library.core.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "book_copy")
@Data
public class BookCopy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "reference", unique = true, nullable = false)
    private String reference;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

}
