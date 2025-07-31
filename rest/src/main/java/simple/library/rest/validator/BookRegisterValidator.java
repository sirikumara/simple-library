package simple.library.rest.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import simple.library.rest.modal.BookDTO;
import simple.library.rest.service.BookService;

@Component
@RequiredArgsConstructor
public class BookRegisterValidator {

    private final BookService bookService;

    public void validate(BookDTO bookDTO) {
        bookService.isValidBook(bookDTO);
    }
}
