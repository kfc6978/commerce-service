package com.gtelant.commerce.service.mappers;

import com.gtelant.commerce.service.dtos.CategoryRequest;
import com.gtelant.commerce.service.dtos.CategoryResponse;
import com.gtelant.commerce.service.dtos.UserRequest;
import com.gtelant.commerce.service.models.Category;
import com.gtelant.commerce.service.models.User;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CategoryMapper {

    public static CategoryResponse toCategoryResponse(Category category) {
        CategoryResponse dto = new CategoryResponse();
        dto.setId(category.getId());
        dto.setName(category.getName());

//        if (category.getProductList() != null) {
//            dto.setProductList(category.getProductList().stream()
//                    .map(this::toCategoryResponse)
//                    .collect(Collectors.toList()));
//        }
        return dto;
    }

    public static Category toCategory(CategoryRequest dto) {
        Category category = new Category();
        category.setName(dto.getName());
        return category;
    }
}
