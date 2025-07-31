package simple.library.rest.modal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookReturnResponseDTO {
    private String borrowerName;
    private String borrowerReference;
    private String message;
}

