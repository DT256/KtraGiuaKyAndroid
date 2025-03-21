package com.giuaky.ktragiuakyandroid.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiServiceLogin {

    @POST("login")
    Call<Response<LoginRequest>> login(@Body LoginRequest loginRequest);
}
