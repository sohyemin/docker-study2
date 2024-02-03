package dockerStudy2.docker2.blog.repository;

import dockerStudy2.docker2.blog.dto.response.BlogResponse;
import dockerStudy2.docker2.blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    public Page<BlogResponse> findByTitle(String title, Pageable pageable);

    public Optional<Blog> findById(Long id);
}
