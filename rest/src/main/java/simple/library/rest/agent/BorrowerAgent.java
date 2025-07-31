package simple.library.rest.agent;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import simple.library.core.entity.Borrower;
import simple.library.rest.converter.BorrowerConverter;
import simple.library.rest.modal.BorrowerDTO;
import simple.library.rest.service.BorrowerService;
import simple.library.rest.validator.BorrowerValidator;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class BorrowerAgent {
    private final BorrowerConverter borrowerConverter;
    private final BorrowerService borrowerService;
    private final BorrowerValidator borrowerValidator;

    public ResponseEntity<?> register(BorrowerDTO borrowerDTO) {
        borrowerValidator.validate(borrowerDTO);
        Borrower borrower = borrowerConverter.convert(borrowerDTO);
        borrower.setReference(UUID.randomUUID().toString());
        borrowerService.save(borrower);
        return ResponseEntity.status(201).body("Borrower registered. Ref: " + borrower.getReference());
    }
}
