package com.devs.blogdevs.dto;

import com.devs.blogdevs.Model.CommentModel;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CommentResponse {
    private Long id;
    private String content;
    private LocalDate createdDate;
    private UserResponse user;

    public CommentResponse(CommentModel comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.createdDate = comment.getDateComent();
        this.user = new UserResponse(comment.getUser());
    }
}
