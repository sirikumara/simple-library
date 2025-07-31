package simple.library.rest.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import simple.library.rest.modal.BorrowerDTO;
import simple.library.rest.service.BorrowerService;

@Component
@RequiredArgsConstructor
public class BorrowerValidator {

    private final BorrowerService borrowerService;

    public void validate(BorrowerDTO borrowerDTO) {
        borrowerService.isExistingBorrower(borrowerDTO.getEmail());
    }
}
