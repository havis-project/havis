package com.havis.object.category.controller;

import com.havis.object.category.model.dto.CategoryDTO;
import com.havis.object.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categories")
@RequiredArgsConstructor
@Slf4j
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/create")
    public String category() {
        return "categories/create";
    }

    @PostMapping("/create")
    public String category(CategoryDTO categoryDTO) {
        categoryService.createCategory(categoryDTO);
        return "redirect:/";
    }



//    @PutMapping("/{id}")
//    public ResponseEntity<CategoryEntity> updateCategory(@PathVariable Long id, @RequestBody CategoryEntity updatedCategory) {
//        Optional<CategoryEntity> updated = categoryService.updateCategory(id, updatedCategory.getCategoryName());
//        return updated.map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
//        boolean deleted = categoryService.deleteCategory(id);
//        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
//    }
}
