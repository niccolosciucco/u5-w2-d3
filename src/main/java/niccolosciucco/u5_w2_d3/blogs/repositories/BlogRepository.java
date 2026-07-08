package niccolosciucco.u5_w2_d3.blogs.repositories;

import niccolosciucco.u5_w2_d3.blogs.entities.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BlogRepository extends JpaRepository<Blog, UUID> {
}
