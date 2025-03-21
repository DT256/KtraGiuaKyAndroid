package com.giuaky.ktragiuakyapi.repository;

import com.giuaky.ktragiuakyapi.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> getLatestProducts(int page, int limit);
    int getTotalProducts();
}
