package com.giuaky.ktragiuakyandroid.service;

import com.giuaky.ktragiuakyandroid.dto.ProductResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/*
* @Author 22110422 - Bui Duc Thang
* */
public interface ProductAPIService {
    @GET("api/products")
    Call<ProductResponse> getProducts(
            @Query("category") String category,
            @Query("page") int page,
            @Query("size") int size
    );
}
