package com.gtelant.commerce.service.controllers;

import com.gtelant.commerce.service.dtos.CategoryRequest;
import com.gtelant.commerce.service.dtos.CategoryResponse;
import com.gtelant.commerce.service.dtos.UserRequest;
import com.gtelant.commerce.service.dtos.UserResponse;
import com.gtelant.commerce.service.mappers.CategoryMapper;
import com.gtelant.commerce.service.models.Category;
import com.gtelant.commerce.service.models.User;
import com.gtelant.commerce.service.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categories")
@CrossOrigin("*")
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryController(CategoryService categoryService, CategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryRequest categoryRequest) {
        Category category = categoryMapper.toCategory(categoryRequest);
        Category createdCategory = categoryService.createCategory(category);
        return ResponseEntity.ok(categoryMapper.toCategoryResponse(createdCategory));
    }


    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAllCategories(){

        return ResponseEntity.ok(categoryService.getAllCategories().stream()
                .map(CategoryMapper::toCategoryResponse)
                .collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> updateCategoryById(@PathVariable int id, @RequestBody CategoryRequest categoryRequest){
        Category category = categoryMapper.toCategory(categoryRequest);
        Category updateCategory = categoryService.updateCategory(id, category);
        if (updateCategory == null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(categoryMapper.toCategoryResponse(updateCategory));
        }
    }
}
