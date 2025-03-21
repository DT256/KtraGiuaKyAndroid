package com.giuaky.ktragiuakyandroid.network;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import lombok.Data;

@Data
public class LoginRequest implements Serializable {

    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;

    // Constructors, getters, and setters


    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginRequest() {
    }

}
