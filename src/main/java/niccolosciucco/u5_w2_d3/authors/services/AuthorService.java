package niccolosciucco.u5_w2_d3.authors.services;

import niccolosciucco.u5_w2_d3.authors.entities.Author;
import niccolosciucco.u5_w2_d3.authors.payloads.AuthorPayload;
import niccolosciucco.u5_w2_d3.authors.repositories.AuthorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author post(AuthorPayload newAuthor) {
        Author author = new Author(newAuthor.getName(), newAuthor.getLastName(), newAuthor.getEmail(), newAuthor.getDateOfBirth());
        return this.authorRepository.save(author);
    }

    public Page<Author> get(int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return this.authorRepository.findAll(pageable);
    }

    public Author findById(UUID id) {
        return this.authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autore con ID " + id + " non trovato!"));
    }

    public Author put(UUID id, AuthorPayload updatedAuthor) {
        Author found = this.findById(id);
        found.setName(updatedAuthor.getName());
        found.setLastName(updatedAuthor.getLastName());
        found.setEmail(updatedAuthor.getEmail());
        found.setDateOfBirth(updatedAuthor.getDateOfBirth());

        return this.authorRepository.save(found);
    }

    public void delete(UUID id) {
        Author found = this.findById(id);
        this.authorRepository.delete(found);
    }

}
