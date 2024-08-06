package com.havis.object.category.controller;

import com.havis.object.category.model.entity.CategoryEntity;
import com.havis.object.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryEntity> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryEntity> getCategoryById(@PathVariable Long id) {
        Optional<CategoryEntity> category = categoryService.getCategoryById(id);
        return category.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public CategoryEntity createCategory(@RequestBody CategoryEntity category) {
        return categoryService.createCategory(category.getCategoryName());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryEntity> updateCategory(@PathVariable Long id, @RequestBody CategoryEntity updatedCategory) {
        Optional<CategoryEntity> updated = categoryService.updateCategory(id, updatedCategory.getCategoryName());
        return updated.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        boolean deleted = categoryService.deleteCategory(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
