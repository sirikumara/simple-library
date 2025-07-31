package simple.library.rest.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import simple.library.rest.agent.BookAgent;
import simple.library.rest.modal.BookDTO;
import simple.library.rest.modal.BookResponseDTO;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookAgent agent;

    @GetMapping
    public ResponseEntity<List<BookResponseDTO>> getAll() {
        return agent.getAll();
    }

    @PostMapping
    public ResponseEntity<String> register(@Valid @RequestBody BookDTO book) {
        return agent.register(book);
    }

}
