package simple.library.rest.converter;

import org.springframework.stereotype.Component;
import simple.library.core.entity.Book;
import simple.library.core.entity.BookCopy;

@Component
public class BookCopyConverter {
    public BookCopy convert(Book book) {
        BookCopy entity = new BookCopy();
        entity.setBook(book);
        return entity;
    }
}
