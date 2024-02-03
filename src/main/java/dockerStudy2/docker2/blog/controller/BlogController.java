package dockerStudy2.docker2.blog.controller;

import dockerStudy2.docker2.blog.dto.request.BlogRequest;
import dockerStudy2.docker2.blog.dto.response.BlogResponse;
import dockerStudy2.docker2.blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    //전체 찾기
    @GetMapping("/posts")
    public List<BlogResponse> getPostList() {
        return blogService.findAll();
    }

    //타이틀로 검색
    @GetMapping("/posts/{title}")
    public Page<BlogResponse> getPostByTitle(@PathVariable("title") String title) {
        return blogService.findBytitle(title);
    }

    @PostMapping("/posts")
    public void postBlog(@RequestBody BlogRequest blogRequest) {
        blogService.createPost(blogRequest);
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable("id") Long id) {
        blogService.deletePost(id);
    }

    @PutMapping("/posts/{id}")
    public void updatePost(@PathVariable("id") Long id, @RequestBody BlogRequest blog) {
        blogService.updatePost(id, blog);
    }
}
