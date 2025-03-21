package com.giuaky.ktragiuakyandroid.dto;

import com.giuaky.ktragiuakyandroid.model.ProductModel;

import java.util.List;

import lombok.Data;

/*
 * @Author 22110422 - Bui Duc Thang
 * */
@Data
public class ProductResponse {
    private String status;
    private int total;
    private int page;
    private int limit;
    private int totalPages;
    private List<ProductModel> data;
}
