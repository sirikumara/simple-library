package simple.library.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import simple.library.core.entity.Book;
import simple.library.core.repository.BookRepository;
import simple.library.rest.exception.BookRegisteringException;
import simple.library.rest.modal.BookDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository repository;

    public void save(Book entity) {
        repository.save(entity);
    }

    public List<Book> getAllWithCopies() {
        return repository.findAllWithBookCopies();
    }

    public void isValidBook(BookDTO bookDTO) {
        repository.findByIsbn(bookDTO.getIsbn()).ifPresent(book -> {
            if (!book.getTitle().equalsIgnoreCase(bookDTO.getTitle())) {
                throw new BookRegisteringException("Book title may be wrong");
            }
            if (!book.getAutor().equalsIgnoreCase(bookDTO.getAutor())) {
                throw new BookRegisteringException("Book Autor may be wrong");
            }
        });
    }
}
