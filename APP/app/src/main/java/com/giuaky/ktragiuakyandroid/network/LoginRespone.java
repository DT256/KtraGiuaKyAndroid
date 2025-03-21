package com.giuaky.ktragiuakyandroid.network;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRespone implements Serializable {
    @SerializedName("token")
    private String token;
    @SerializedName("message")
    private String message;
}
