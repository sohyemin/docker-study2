package dockerStudy2.docker2.blog.service;

import dockerStudy2.docker2.blog.dto.request.BlogRequest;
import dockerStudy2.docker2.blog.dto.response.BlogResponse;
import dockerStudy2.docker2.blog.entity.Blog;
import dockerStudy2.docker2.blog.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BlogServiceImpl implements BlogService{

    private final BlogRepository blogRepository;

    @Override
    @Transactional(readOnly = false)
    public void createPost(BlogRequest blog) {
        blogRepository.save(blog.toEntity());
    }

    @Override
    public Page<BlogResponse> findBytitle(String title) {
        Pageable pageable = PageRequest.of(0, 5);
        return blogRepository.findByTitle(title, pageable);
    }

    @Override
    public List<BlogResponse> findAll() {
        log.info("Blog list");
        return blogRepository.findAll().stream().map(blog -> BlogResponse.from(blog))
                .toList();
    }

    @Override
    @Transactional(readOnly = false)
    public void updatePost(Long id, BlogRequest blogRequest) {
        Blog findBlog = blogRepository.findById(id).get();
        findBlog.changeBlog(blogRequest.getTitle(), blogRequest.getContent());
    }

    @Override
    @Transactional(readOnly = false)
    public void deletePost(Long id) {
        blogRepository.delete(blogRepository.findById(id).get());
    }
}
