package niccolosciucco.u5_w2_d3.blogs.controllers;

import niccolosciucco.u5_w2_d3.blogs.entities.Blog;
import niccolosciucco.u5_w2_d3.blogs.payloads.BlogPayload;
import niccolosciucco.u5_w2_d3.blogs.services.BlogService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blogs")
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService BlogService) {
        this.blogService = BlogService;
    }

    @GetMapping
    public Page<Blog> get(@RequestParam(defaultValue = "0") int page) {
        return this.blogService.get(page);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Blog post(@RequestBody BlogPayload body) {
        return this.blogService.save(body);
    }
}
