package advanced.spring.rest.web;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;


import advanced.spring.rest.model.Author;
import advanced.spring.rest.repository.AuthorRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthorsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private AuthorRepository mockAuthorRepository;

    private Author author1, author2;

    private int NEW_AUTHOR_ID = 3;
    private int NON_EXISTANT_AUTHOR_ID = 42;

    @BeforeEach
    public void setUp() {
        author1 = new Author().setId(1).setName("Author 1");
        author2 = new Author().setId(2).setName("Author 2");

        when(mockAuthorRepository.findById(author1.getId())).thenReturn(Optional.of(author1));
        when(mockAuthorRepository.findById(author2.getId())).thenReturn(Optional.of(author2));
        when(mockAuthorRepository.findAll()).thenReturn(List.of(author1, author2));

        when(mockAuthorRepository.save(any())).thenAnswer(
                (Answer<Author>) invocation -> {
                    Author authorToSave = invocation.getArgument(0);
                    authorToSave.setId(NEW_AUTHOR_ID);
                    return authorToSave;
                }
        );
    }

    @Test
    public void testAuthorsReturnsCorrectStatusCode() throws Exception {
        this.mockMvc.perform(get("/authors")).
                andExpect(status().isOk());
    }

    @Test
    public void testAuthorNotFound() throws Exception {
        this.mockMvc.perform(get("/authors/{id}", NON_EXISTANT_AUTHOR_ID)).
                andExpect(status().isNotFound());
    }

    @Test
    public void testAuthor1Found() throws Exception {
        this.mockMvc.
                perform(get("/authors/{id}", author1.getId())).
                andExpect(status().isOk()).
                andExpect(jsonPath("$.name", is(author1.getName())));
    }

    @Test
    public void testAuthor2Found() throws Exception {
        this.mockMvc.
                perform(get("/authors/{id}", author2.getId())).
                andExpect(status().isOk()).
                andExpect(jsonPath("$.name", is(author2.getName())));
    }

    @Test
    public void testAllAuthors() throws Exception {
        this.mockMvc.
                perform(get("/authors")).
                andExpect(status().isOk()).
                andExpect(jsonPath("$", hasSize(2))).
                andExpect(jsonPath("$.[0].id", is((int) author1.getId()))).
                andExpect(jsonPath("$.[0].name", is(author1.getName()))).
                andExpect(jsonPath("$.[1].id", is((int) author2.getId()))).
                andExpect(jsonPath("$.[1].name", is(author2.getName())));
    }

    @Test
    public void testCreateNewAuthor() throws Exception {
        Author newAuthorExpected = new Author().setName("NEW AUTHOR");
        String json = objectMapper.writeValueAsString(newAuthorExpected);

        this.mockMvc.perform(
                post("/authors").
                        contentType(MediaType.APPLICATION_JSON).
                        content(json).
                        accept(MediaType.APPLICATION_JSON)).
                andExpect(status().isCreated());

        ArgumentCaptor<Author> argument = ArgumentCaptor.forClass(Author.class);
        Mockito.verify(mockAuthorRepository, times(1)).save(argument.capture());

        Author newAuthorActual = argument.getValue();

        Assertions.assertEquals(newAuthorExpected.getName(), newAuthorActual.getName());
        Assertions.assertEquals(NEW_AUTHOR_ID, newAuthorActual.getId());
    }

}