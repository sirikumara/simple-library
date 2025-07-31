package simple.library.rest.modal;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BookReturnDTO {
    @NotBlank(message = "Book Reference is required")
    private String bookReference;
}

