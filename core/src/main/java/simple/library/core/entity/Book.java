package simple.library.core.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "book")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "isbn", nullable = false, unique = true)
    private String isbn;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "autor", nullable = false)
    private String autor;
    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BookCopy> bookCopies;
}
