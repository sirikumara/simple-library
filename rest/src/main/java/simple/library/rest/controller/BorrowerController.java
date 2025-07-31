package simple.library.rest.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import simple.library.rest.agent.BorrowerAgent;
import simple.library.rest.modal.BorrowerDTO;

@RestController
@RequestMapping("/api/borrowers")
@RequiredArgsConstructor
public class BorrowerController {
    private final BorrowerAgent agent;

    @PostMapping
    public ResponseEntity<?> register(@Valid @RequestBody BorrowerDTO borrower) {
        return agent.register(borrower);
    }

}
