package com.giuaky.ktragiuakyandroid.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

//Pham Trung Ky 22110361
public interface ApiServiceLogin {

    @POST("api/auth/login")
    Call<LoginRespone> login(@Body LoginRequest loginRequest);
}
