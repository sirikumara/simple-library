package simple.library.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import simple.library.core.entity.Borrower;
import simple.library.core.repository.BorrowerRepository;
import simple.library.rest.exception.BorrowerException;

@Service
@RequiredArgsConstructor
public class BorrowerService {
    private final BorrowerRepository repository;

    public void save(Borrower entity) {
        repository.save(entity);
    }

    public Borrower getBorrower(String reference) {
        return repository.findByReference(reference)
                .orElseThrow(() -> new BorrowerException("Borrower ref:" + reference + " not found"));
    }

    public void isExistingBorrower(String email) {
        if (repository.existsByEmail(email)) {
            throw new BorrowerException("Already registered with email: " + email);
        }
    }
}
