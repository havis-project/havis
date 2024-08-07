package com.havis.object.category.service;

import com.havis.object.category.model.dto.CategoryDTO;
import com.havis.object.category.model.entity.CategoryEntity;
import com.havis.object.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public void category(CategoryDTO categoryDTO) {

        CategoryEntity category = CategoryEntity.builder()
                .categoryName(categoryDTO.getCategoryName())
                .build();

        log.info("[카테고리생성] 카테고리번호 : {} 카테고리명 : {}", category.getCategoryNo(), category.getCategoryName());

        CategoryEntity newCategory = categoryRepository.save(category);
    }

//    public Optional<CategoryEntity> updateCategory(Long id, String newName) {
//        return categoryRepository.findById(id).map(category -> {
//            category.setCategoryName(newName);
//            return categoryRepository.save(category);
//        });
//    }
//
//    public boolean deleteCategory(Long id) {
//        if (categoryRepository.existsById(id)) {
//            categoryRepository.deleteById(id);
//            return true;
//        }
//        return false;
//    }
}
