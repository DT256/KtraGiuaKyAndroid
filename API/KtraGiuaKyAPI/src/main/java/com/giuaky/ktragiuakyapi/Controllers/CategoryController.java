package com.giuaky.ktragiuakyapi.Controllers;

import com.giuaky.ktragiuakyapi.Entity.Category;
import com.giuaky.ktragiuakyapi.Services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Ten:Nguyen Hoai Tan
// MSSV: 22110413
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories(){
        return categoryService.getAllCategory();
    }
}
