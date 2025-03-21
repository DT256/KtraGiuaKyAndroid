package com.giuaky.ktragiuakyandroid.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServiceLogin {

    @GET("categories.php")
    Call<List<LoginRequest>> getCategoryAll();
}
