package simple.library.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import simple.library.core.entity.BookCopy;

import java.util.Optional;
import java.util.UUID;

public interface BookCopyRepository extends JpaRepository<BookCopy, UUID> {
    Optional<BookCopy> findByReference(String reference);
}
