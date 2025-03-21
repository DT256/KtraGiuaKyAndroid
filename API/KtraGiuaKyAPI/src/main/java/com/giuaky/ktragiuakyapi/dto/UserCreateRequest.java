package com.giuaky.ktragiuakyapi.dto;


public class UserCreateRequest {
    private String email;

    public String getUsername() {
        return username;
    }

    public UserCreateRequest(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
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

    private String username;
    private String password;
}
