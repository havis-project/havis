package com.havis.object.category.service;

import com.havis.object.category.model.dto.CategoryDTO;
import com.havis.object.category.model.entity.CategoryEntity;
import com.havis.object.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryEntity> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<CategoryEntity> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public void category(CategoryDTO categoryDTO) {

        CategoryEntity category = CategoryEntity.builder()
                .categoryName(categoryDTO.getCategory_name())
                .build();

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
