package simple.library.rest.converter;

import org.springframework.stereotype.Component;
import simple.library.core.entity.Book;
import simple.library.core.entity.BookCopy;
import simple.library.rest.modal.BookDTO;
import simple.library.rest.modal.BookResponseDTO;

import java.util.stream.Collectors;

@Component
public class BookConverter {
    public Book convert(BookDTO dto) {
        Book entity = new Book();
        entity.setIsbn(dto.getIsbn());
        entity.setTitle(dto.getTitle());
        entity.setAutor(dto.getAutor());
        return entity;
    }

    public BookResponseDTO convert(Book entity) {
        BookResponseDTO dto = new BookResponseDTO();
        dto.setIsbn(entity.getIsbn());
        dto.setTitle(entity.getTitle());
        dto.setAutor(entity.getAutor());
        dto.setBookCopyReferences(entity.getBookCopies().stream().map(BookCopy::getReference).collect(Collectors.toList()));
        return dto;
    }
}
