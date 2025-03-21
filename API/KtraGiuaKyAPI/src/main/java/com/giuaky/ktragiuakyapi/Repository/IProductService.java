package com.giuaky.ktragiuakyapi.Repository;

import com.giuaky.ktragiuakyapi.Product;

import java.util.List;

public interface IProductService {
    List<Product> getLatestProducts(int page, int limit);
    int getTotalProducts();
}
