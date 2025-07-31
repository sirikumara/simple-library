package simple.library.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import simple.library.core.entity.BookCopy;
import simple.library.core.repository.BookCopyRepository;
import simple.library.rest.exception.BookCopyException;

@Service
@RequiredArgsConstructor
public class BookCopyService {
    private final BookCopyRepository repository;

    public BookCopy findByReference(String reference) {
        return repository.findByReference(reference)
                .orElseThrow(()-> new BookCopyException("Referenced book not found"));
    }
}
