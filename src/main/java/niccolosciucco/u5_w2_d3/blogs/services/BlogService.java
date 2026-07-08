package niccolosciucco.u5_w2_d3.blogs.services;

import niccolosciucco.u5_w2_d3.authors.entities.Author;
import niccolosciucco.u5_w2_d3.authors.repositories.AuthorRepository;
import niccolosciucco.u5_w2_d3.blogs.entities.Blog;
import niccolosciucco.u5_w2_d3.blogs.payloads.BlogPayload;
import niccolosciucco.u5_w2_d3.blogs.repositories.BlogRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BlogService {
    private final BlogRepository blogRepository;
    private final AuthorRepository authorRepository;

    public BlogService(BlogRepository blogRepository, AuthorRepository authorRepository) {
        this.blogRepository = blogRepository;
        this.authorRepository = authorRepository;
    }

    public Page<Blog> get(int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return this.blogRepository.findAll(pageable);
    }

    public Author findById(UUID authorId) {
        return authorRepository.findById(authorId).orElse(null);
    }

    public Blog save(BlogPayload payload) {
        Author author = authorRepository.findById(payload.getAuthorId()).orElse(null);
        Blog blog = new Blog(payload.getCategory(), payload.getTitle(), payload.getPlot(), payload.getReadingTime(), author);
        return this.blogRepository.save(blog);
    }

    public Blog findBlogById(UUID id) {
        return this.blogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog con ID " + id + " non trovato"));
    }

    public Blog put(UUID id, BlogPayload updatedPayload) {
        Blog found = this.findBlogById(id);
        Author author = this.authorRepository.findById(updatedPayload.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Autore con ID " + updatedPayload.getAuthorId() + " non trovato"));

        found.setCategory(updatedPayload.getCategory());
        found.setTitle(updatedPayload.getTitle());
        found.setPlot(updatedPayload.getPlot());
        found.setReadingTime(updatedPayload.getReadingTime());
        found.setAuthor(author);

        return this.blogRepository.save(found);
    }

    public void delete(UUID id) {
        Blog found = this.findBlogById(id);
        this.blogRepository.delete(found);
    }
}
