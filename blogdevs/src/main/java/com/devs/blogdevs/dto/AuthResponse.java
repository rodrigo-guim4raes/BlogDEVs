package com.devs.blogdevs.dto;
//O QUE O SERVIDOR DEVOLVE APÓS O USUARIO FAZER O LOGIN
public class AuthResponse {
    private String token;

    public AuthResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
