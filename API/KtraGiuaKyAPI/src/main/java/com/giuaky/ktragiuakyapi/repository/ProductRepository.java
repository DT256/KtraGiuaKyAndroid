package com.giuaky.ktragiuakyapi.repository;

import com.giuaky.ktragiuakyapi.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//22110429_VoNguyenXuanThinh
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryId(Long categoryId); // Giữ nguyên
    Page<Product> findByCategoryId(Long categoryId, Pageable pageable);
}
