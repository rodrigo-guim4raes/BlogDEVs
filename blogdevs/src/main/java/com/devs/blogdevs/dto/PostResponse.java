package com.devs.blogdevs.dto;

import com.devs.blogdevs.Model.PostModel;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PostResponse {
    private Long id;
    private String title;
    private String content;
    private LocalDate CreatedDate;
    private UserResponse user;

    public PostResponse (PostModel post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.CreatedDate = post.getCreatedDate();
        this.user = new UserResponse (post.getUser());
    }
}
