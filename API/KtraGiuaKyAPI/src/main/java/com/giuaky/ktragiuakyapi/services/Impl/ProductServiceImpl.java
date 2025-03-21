package com.giuaky.ktragiuakyapi.services.Impl;

import com.giuaky.ktragiuakyapi.entity.Product;
import com.giuaky.ktragiuakyapi.repository.IProductService;
import com.giuaky.ktragiuakyapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    //22110429_VoNguyenXuanThinh
    public List<Product> getLatestProducts(int page, int limit) {
        // Tạo đối tượng Pageable để phân trang và sắp xếp (theo id giảm dần)
        Pageable pageable = PageRequest.of(page - 1, limit, Sort.by("id").descending());
        return productRepository.findAll(pageable).getContent();
    }

    @Override
    //22110429_VoNguyenXuanThinh
    public int getTotalProducts() {
        return (int) productRepository.count();
    }
}
