package simple.library.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import simple.library.core.entity.Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
    @Query("SELECT b FROM Book b LEFT JOIN FETCH b.bookCopies")
    List<Book> findAllWithBookCopies();

    Optional<Book> findByIsbn(String isbn);

}
