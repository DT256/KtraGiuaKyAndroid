package com.giuaky.ktragiuakyapi.controller;

import com.giuaky.ktragiuakyapi.Services.IProductService;
import com.giuaky.ktragiuakyapi.entity.Product;
import com.giuaky.ktragiuakyapi.repository.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
// 22110429_VoNguyenXuanThinh
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/products")
    public ResponseEntity<Map<String, Object>> getProducts(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "12") int limit) {

        List<Product> products = productService.getLatestProducts(page, limit);
        int totalProducts = productService.getTotalProducts();

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("total", totalProducts);
        response.put("page", page);
        response.put("limit", limit);
        response.put("totalPages", (int) Math.ceil((double) totalProducts / limit));
        response.put("data", products);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/products/by-category")
    public ResponseEntity<Map<String, Object>> getProductsByCategory(
            @RequestParam Long categoryId,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "12") int limit) {

        List<Product> products = productService.getProductsByCategoryId(categoryId, page, limit);
        int totalProducts = productService.getTotalProductsByCategoryId(categoryId);

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("total", totalProducts);
        response.put("page", page);
        response.put("limit", limit);
        response.put("totalPages", (int) Math.ceil((double) totalProducts / limit));
        response.put("data", products);

        return ResponseEntity.ok(response);
    }
}
