package simple.library.rest.modal;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BookLoanDTO {
    @NotBlank(message = "Borrower Reference is required")
    private String borrowerReference;
    @NotBlank(message = "Book Reference is required")
    private String bookReference;
}

