package com.giuaky.ktragiuakyapi.Services.Impl;

import com.giuaky.ktragiuakyapi.Entity.Category;
import com.giuaky.ktragiuakyapi.Repository.CategoryRepository;
import com.giuaky.ktragiuakyapi.Services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



// Ten:Nguyen Hoai Tan
// MSSV: 22110413
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }
}
