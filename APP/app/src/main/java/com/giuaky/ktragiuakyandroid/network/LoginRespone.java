package com.giuaky.ktragiuakyandroid.network;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class LoginRespone {
    private String id;
    private String fullName;
    private String email;
    private String username;
    private String urlAvatar;

    // Getters
    public String getId() { return id; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getUsername() { return username; }
    public String getUrlAvatar() { return urlAvatar; }
}
