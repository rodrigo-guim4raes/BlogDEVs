package com.devs.blogdevs.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PostRequest {
    private String title;
    private String content;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate createdDate;

    private Long userID;
}

