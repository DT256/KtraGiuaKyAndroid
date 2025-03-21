// ProductAPIService.java
package com.giuaky.ktragiuakyandroid.service;

import com.giuaky.ktragiuakyandroid.dto.ProductResponse;
import com.giuaky.ktragiuakyandroid.model.CategoryModel;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

//22110422 Bui Duc Thang
public interface ProductAPIService {
    @GET("api/products")
    Call<ProductResponse> getProducts(
            @Query("category") Long categoryId,
            @Query("page") int page,
            @Query("size") int size
    );

    @GET("api/categories")
    Call<List<CategoryModel>> getCategories();
}