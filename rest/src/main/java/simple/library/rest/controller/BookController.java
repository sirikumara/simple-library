package simple.library.rest.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import simple.library.rest.agent.BookAgent;
import simple.library.rest.modal.BookDTO;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookAgent agent;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return agent.getAll();
    }

    @PostMapping
    public ResponseEntity<?> register(@Valid @RequestBody BookDTO book) {
        return agent.register(book);
    }

}
