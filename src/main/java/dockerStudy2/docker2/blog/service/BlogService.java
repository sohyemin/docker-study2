package dockerStudy2.docker2.blog.service;

import dockerStudy2.docker2.blog.dto.request.BlogRequest;
import dockerStudy2.docker2.blog.dto.response.BlogResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BlogService {

    //CRUD
    public void createPost(BlogRequest blogRequest);

    public Page<BlogResponse> findBytitle(String title);
    public List<BlogResponse> findAll();

    public void updatePost(Long id, BlogRequest blogRequest);

    public void deletePost(Long id);
}
