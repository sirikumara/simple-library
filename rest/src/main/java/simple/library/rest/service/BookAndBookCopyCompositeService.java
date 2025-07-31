package simple.library.rest.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import simple.library.core.entity.Book;
import simple.library.core.entity.BookCopy;
import simple.library.core.repository.BookCopyRepository;
import simple.library.core.repository.BookRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookAndBookCopyCompositeService {
    private final BookRepository bookRepository;
    private final BookCopyRepository bookCopyRepository;

    @Transactional
    public void save(Book book, BookCopy bookCopy) {
        bookRepository.findByIsbn(book.getIsbn())
                .ifPresentOrElse(bookCopy::setBook, () -> {
                    bookRepository.save(book);
                });
        bookCopy.setReference(UUID.randomUUID().toString());
        bookCopyRepository.save(bookCopy);

    }

}
