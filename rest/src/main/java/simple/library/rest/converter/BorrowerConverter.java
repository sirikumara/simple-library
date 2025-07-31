package simple.library.rest.converter;

import org.springframework.stereotype.Component;
import simple.library.core.entity.Borrower;
import simple.library.rest.modal.BorrowerDTO;

@Component
public class BorrowerConverter {
    public Borrower convert(BorrowerDTO dto) {
        Borrower entity = new Borrower();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        return entity;
    }
}
