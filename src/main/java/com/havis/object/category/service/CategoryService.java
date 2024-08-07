package com.havis.object.category.service;

import com.havis.object.category.model.dto.CategoryDTO;
import com.havis.object.category.model.entity.CategoryEntity;
import com.havis.object.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public void createCategory(CategoryDTO categoryDTO) {

        CategoryEntity category = CategoryEntity.builder()
                .categoryName(categoryDTO.getCategoryName())
                .build();

        log.info("[카테고리생성] 카테고리명 : {}", category.getCategoryName());

        categoryRepository.saveAndFlush(category);
    }


}
