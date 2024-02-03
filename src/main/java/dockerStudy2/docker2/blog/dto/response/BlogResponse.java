package dockerStudy2.docker2.blog.dto.response;

import dockerStudy2.docker2.blog.entity.Blog;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class BlogResponse {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime created_at;

    public static BlogResponse from(Blog blog) {
        return BlogResponse.builder()
                .id(blog.getId())
                .title(blog.getTitle())
                .content(blog.getContent())
                .created_at(blog.getCreated_at())
                .build();
    }
}
