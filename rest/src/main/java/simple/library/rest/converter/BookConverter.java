package simple.library.rest.converter;

import org.springframework.stereotype.Component;
import simple.library.core.entity.Book;
import simple.library.rest.modal.BookDTO;

@Component
public class BookConverter {
    public Book convert(BookDTO dto) {
        Book entity = new Book();
        entity.setIsbn(dto.getIsbn());
        entity.setTitle(dto.getTitle());
        entity.setAutor(dto.getAutor());
        return entity;
    }
    public BookDTO convert(Book entity) {
        BookDTO dto = new BookDTO();
        dto.setIsbn(entity.getIsbn());
        dto.setTitle(entity.getTitle());
        dto.setAutor(entity.getAutor());
        return dto;
    }
}
