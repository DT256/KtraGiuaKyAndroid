package com.giuaky.ktragiuakyapi.dto;



//Ho Le Tan Loi 22110370
public class UserResponse {
    public UserResponse() {}
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUrlAvatar() {
        return urlAvatar;
    }

    public void setUrlAvatar(String urlAvatar) {
        this.urlAvatar = urlAvatar;
    }

    public UserResponse(Long id, String fullName, String email, String username, String urlAvatar) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.username = username;
        this.urlAvatar = urlAvatar;
    }

    private String fullName;
    private String email;
    private String username;
    private String urlAvatar;
}
