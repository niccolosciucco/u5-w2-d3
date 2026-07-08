package niccolosciucco.u5_w2_d3.authors.controllers;

import niccolosciucco.u5_w2_d3.authors.entities.Author;
import niccolosciucco.u5_w2_d3.authors.payloads.AuthorPayload;
import niccolosciucco.u5_w2_d3.authors.services.AuthorService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public Page<Author> get(@RequestParam(defaultValue = "0") int page) {
        return this.authorService.get(page);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author post(@RequestBody AuthorPayload payload) {
        return this.authorService.post(payload);
    }

    @PutMapping("/{id}")
    public Author put(@PathVariable UUID id, @RequestBody AuthorPayload payload) {
        return this.authorService.put(id, payload);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        this.authorService.delete(id);
    }
}
