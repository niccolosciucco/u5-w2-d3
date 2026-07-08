package niccolosciucco.u5_w2_d3.authors.repositories;

import niccolosciucco.u5_w2_d3.authors.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthorRepository extends JpaRepository<Author, UUID> {
}
