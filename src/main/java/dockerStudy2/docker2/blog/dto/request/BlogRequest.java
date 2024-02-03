package dockerStudy2.docker2.blog.dto.request;

import dockerStudy2.docker2.blog.entity.Blog;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BlogRequest {
    private String title;
    private String content;

    public Blog toEntity() {
        return Blog.builder()
                .title(title)
                .content(content)
                .build();
    }
}
