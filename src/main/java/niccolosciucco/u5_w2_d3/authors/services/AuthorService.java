package niccolosciucco.u5_w2_d3.authors.services;

import niccolosciucco.u5_w2_d3.authors.entities.Author;
import niccolosciucco.u5_w2_d3.authors.payloads.AuthorPayload;
import niccolosciucco.u5_w2_d3.authors.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author save(AuthorPayload newAuthor) {
        Author author = new Author(newAuthor.getName(), newAuthor.getLastName(), newAuthor.getEmail(), newAuthor.getDateOfBirth());
        return this.authorRepository.save(author);
    }

}
