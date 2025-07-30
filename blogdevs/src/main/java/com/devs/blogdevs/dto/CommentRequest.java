package com.devs.blogdevs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CommentRequest {
    @JsonProperty("content")
    private String content;

    private Long userId;
    private Long postId;

    public CommentRequest() {
    }
}
