package simple.library.rest.modal;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class BookResponseDTO {
    private String isbn;
    private String title;
    private String autor;
    private List<String> bookCopyReferences;
}

