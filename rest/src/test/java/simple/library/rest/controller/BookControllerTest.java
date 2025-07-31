package simple.library.rest.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import simple.library.rest.agent.BookAgent;
import simple.library.rest.modal.BookDTO;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = BookController.class)
@AutoConfigureMockMvc
class BookControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookAgent bookAgent;

    @BeforeEach
    public void setup() {
        BookDTO b1 = new BookDTO();
        b1.setAutor("A1");
        b1.setIsbn("1234");
        b1.setTitle("T1");
        BookDTO b2 = new BookDTO();
        b2.setAutor("A1");
        b2.setIsbn("1234");
        b2.setTitle("T1");
        when(bookAgent.getAll()).thenReturn(ResponseEntity.accepted().body(List.of(b1, b2)));
    }
//
//    @Test
//    void getAll_returnAllRegisteredBooks() throws Exception {
//
//        mockMvc.perform(get("/api/books"))
//                .andExpect(status().isOk());
//    }

}