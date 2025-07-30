package com.devs.blogdevs.dto;

import com.devs.blogdevs.Model.UserModel;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private LocalDate createdDate ;

    public UserResponse(UserModel user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.createdDate  = user.getRegistrationDate().toLocalDate();
    }
}
