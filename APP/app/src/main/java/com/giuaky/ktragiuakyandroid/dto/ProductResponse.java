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

    public List<ProductModel> getData() {
        return data;
    }

    public void setData(List<ProductModel> data) {
        this.data = data;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private List<ProductModel> data;
}
