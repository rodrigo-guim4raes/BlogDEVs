package com.devs.blogdevs.dto;

import jakarta.validation.constraints.NotBlank;

//USUARIO ENVIA PARA FAZER O LOGIN
public class AuthRequest {

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    public AuthRequest() {
    }

    public AuthRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
