package simple.library.rest.agent;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import simple.library.core.entity.Book;
import simple.library.core.entity.BookCopy;
import simple.library.rest.converter.BookConverter;
import simple.library.rest.converter.BookCopyConverter;
import simple.library.rest.modal.BookDTO;
import simple.library.rest.service.BookAndBookCopyCompositeService;
import simple.library.rest.service.BookService;
import simple.library.rest.validator.BookRegisterValidator;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BookAgent {
    private final BookConverter bookConverter;
    private final BookCopyConverter bookCopyConverter;
    private final BookService bookService;
    private final BookAndBookCopyCompositeService bookAndBookCopyCompositeService;
    private final BookRegisterValidator bookRegisterValidator;

    public ResponseEntity<?> register(BookDTO bookDTO) {
        bookRegisterValidator.validate(bookDTO);
        Book book = bookConverter.convert(bookDTO);
        BookCopy bookCopy = bookCopyConverter.convert(book);
        bookAndBookCopyCompositeService.save(book, bookCopy);
        return ResponseEntity.status(201).body("Book registered. Ref: " + bookCopy.getReference());
    }

    public ResponseEntity<List<BookDTO>> getAll() {
        List<Book> bookList = bookService.getAllWithCopies();
        return ResponseEntity.ok().body(bookList.stream().map(bookConverter::convert).collect(Collectors.toList()));
    }
}
