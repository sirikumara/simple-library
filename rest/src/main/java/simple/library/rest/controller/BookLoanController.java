package simple.library.rest.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import simple.library.rest.agent.BookLoanAgent;
import simple.library.rest.modal.BookLoanDTO;
import simple.library.rest.modal.BookReturnDTO;
import simple.library.rest.modal.BookReturnResponseDTO;

@RestController
@RequestMapping("/api/book-loans")
@RequiredArgsConstructor
public class BookLoanController {
    private final BookLoanAgent agent;

    @PostMapping
    public ResponseEntity<String> loanBook(@Valid @RequestBody BookLoanDTO bookLoan) {
        return agent.loanBook(bookLoan);
    }

    @PatchMapping
    public ResponseEntity<BookReturnResponseDTO> returnBook(@Valid @RequestBody BookReturnDTO bookReturn) {
        return agent.returnBook(bookReturn);
    }

}
