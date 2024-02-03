package dockerStudy2.docker2.blog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Blog {

    @Id @GeneratedValue
    private Long id;

    private String content;
    private String title;

    @Column(updatable = false)
    private LocalDateTime created_at;

    @Builder
    public Blog(String title, String content) {
        this.title = title;
        this.content = content;
        this.created_at = LocalDateTime.now();
    }

    public void changeBlog(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
