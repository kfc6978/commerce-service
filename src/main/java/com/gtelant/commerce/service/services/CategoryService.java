package com.gtelant.commerce.service.services;

import com.gtelant.commerce.service.models.Category;
import com.gtelant.commerce.service.models.User;
import com.gtelant.commerce.service.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    public Category updateCategory(int id, Category category){
        if(categoryRepository.existsById(id)){
            category.setId(id);
            return categoryRepository.save(category);
        }
        return null;
    }
}
