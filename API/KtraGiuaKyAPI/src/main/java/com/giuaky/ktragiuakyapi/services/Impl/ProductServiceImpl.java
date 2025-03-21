package com.giuaky.ktragiuakyapi.services.impl;

import com.giuaky.ktragiuakyapi.Services.IProductService;
import com.giuaky.ktragiuakyapi.entity.Product;
import com.giuaky.ktragiuakyapi.services.IProductService;
import com.giuaky.ktragiuakyapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//22110429_VoNguyenXuanThinh
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getLatestProducts(int page, int limit) {
        // Tạo đối tượng Pageable để phân trang và sắp xếp (theo id giảm dần)
        Pageable pageable = PageRequest.of(page - 1, limit, Sort.by("id").descending());
        return productRepository.findAll(pageable).getContent();
    }

    @Override
    public int getTotalProducts() {
        return (int) productRepository.count();
    }

    @Override
    public List<Product> getProductsByCategoryId(Long categoryId, int page, int limit) {
        // Sắp xếp theo giá tăng dần, lọc theo categoryId
        Pageable pageable = PageRequest.of(page - 1, limit, Sort.by("price").ascending());
        return productRepository.findByCategoryId(categoryId, pageable).getContent();
        return List.of();
    }

}
