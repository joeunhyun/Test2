package org.example.springboot.web.dto;

import lombok.Getter;
import org.example.springboot.domain.posts.Posts;

@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity){
        this.id = entity.getId();
        this.content = entity.getContent();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
    }
}
