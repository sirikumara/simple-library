package simple.library.rest.agent;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import simple.library.core.entity.Book;
import simple.library.core.entity.BookCopy;
import simple.library.rest.converter.BookConverter;
import simple.library.rest.converter.BookCopyConverter;
import simple.library.rest.modal.BookDTO;
import simple.library.rest.modal.BookResponseDTO;
import simple.library.rest.service.BookAndBookCopyCompositeService;
import simple.library.rest.service.BookService;
import simple.library.rest.validator.BookRegisterValidator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookAgentTest {
    @Mock
    private BookConverter bookConverter;
    @Mock
    private BookCopyConverter bookCopyConverter;
    @Mock
    private BookService bookService;
    @Mock
    private BookAndBookCopyCompositeService bookAndBookCopyCompositeService;
    @Mock
    private BookRegisterValidator bookRegisterValidator;
    @Mock
    private BookDTO bookDTO;
    @Mock
    private Book book, book1, book2;
    @Mock
    private BookResponseDTO bookRes1, bookRes2;
    @Mock
    private BookCopy bookCopy;
    private BookAgent bookAgent;

    private static final String BOOK_COPY_REFERENCE = "BOOK_COPY_REFERENCE";
    private static final String AUTHOR1 = "AUTHOR1";
    private static final String TITLE1 = "TITLE1";
    private static final String ISBN1 = "ISBN1";
    private static final String REF1 = "REF1";

    @BeforeEach
    public void setup() {
        this.bookAgent = new BookAgent(bookConverter, bookCopyConverter, bookService, bookAndBookCopyCompositeService, bookRegisterValidator);
    }

    @Test
    public void register() {
        when(bookCopy.getReference()).thenReturn(BOOK_COPY_REFERENCE);
        when(bookConverter.convert(bookDTO)).thenReturn(book);
        when(bookCopyConverter.convert(book)).thenReturn(bookCopy);
        ResponseEntity<String> response = bookAgent.register(bookDTO);
        verify(bookAndBookCopyCompositeService).save(book, bookCopy);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Book registered. Ref: BOOK_COPY_REFERENCE", response.getBody());
    }

    @Test
    public void getAll() {
        when(bookService.getAllWithCopies()).thenReturn(List.of(book1, book2));
        when(bookConverter.convert(book1)).thenReturn(bookRes1);
        when(bookConverter.convert(book2)).thenReturn(bookRes2);
        when(bookRes1.getAutor()).thenReturn(AUTHOR1);
        when(bookRes1.getTitle()).thenReturn(TITLE1);
        when(bookRes1.getIsbn()).thenReturn(ISBN1);
        when(bookRes1.getBookCopyReferences()).thenReturn(List.of(REF1));
        ResponseEntity<List<BookResponseDTO>> response = bookAgent.getAll();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        assertEquals(2, response.getBody().size());
        assertEquals(AUTHOR1, response.getBody().getFirst().getAutor());
        assertEquals(ISBN1, response.getBody().getFirst().getIsbn());
        assertEquals(TITLE1, response.getBody().getFirst().getTitle());
        assertEquals(REF1, response.getBody().getFirst().getBookCopyReferences().getFirst());
    }

}