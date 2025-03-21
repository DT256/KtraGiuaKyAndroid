package com.giuaky.ktragiuakyapi;

import com.giuaky.ktragiuakyapi.Repository.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
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
