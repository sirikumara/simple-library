package simple.library.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import simple.library.core.entity.Borrower;

import java.util.Optional;
import java.util.UUID;

public interface BorrowerRepository extends JpaRepository<Borrower, UUID> {
    Optional<Borrower> findByReference(String reference);

    boolean existsByEmail(String email);
}
