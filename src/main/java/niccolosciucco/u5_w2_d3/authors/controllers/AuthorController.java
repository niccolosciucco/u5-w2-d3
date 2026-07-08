package niccolosciucco.u5_w2_d3.authors.controllers;

import niccolosciucco.u5_w2_d3.authors.entities.Author;
import niccolosciucco.u5_w2_d3.authors.payloads.AuthorPayload;
import niccolosciucco.u5_w2_d3.authors.services.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author post(@RequestBody AuthorPayload payload) {
        return this.authorService.save(payload);
    }
}
