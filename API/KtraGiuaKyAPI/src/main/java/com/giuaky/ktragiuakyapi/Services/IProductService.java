package com.giuaky.ktragiuakyapi.Services;

import com.giuaky.ktragiuakyapi.Product;

import java.util.List;

//22110429_VoNguyenXuanThinh
public interface IProductService {
    List<Product> getLatestProducts(int page, int limit);
    int getTotalProducts();
    List<Product> getProductsByCategoryId(Long categoryId, int page, int limit); // Thêm phương thức mới
    int getTotalProductsByCategoryId(Long categoryId);
}
