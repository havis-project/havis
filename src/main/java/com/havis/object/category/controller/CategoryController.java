package com.havis.object.category.controller;

import com.havis.common.Pagenation;
import com.havis.common.PagingButtonInfo;
import com.havis.object.category.model.dto.CategoryDTO;
import com.havis.object.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Controller
@RequestMapping("/category")
@RequiredArgsConstructor
@Slf4j
public class CategoryController {

    private final CategoryService categoryService;


    @GetMapping("/create")
    public String category() {
        return "category/create";
    }

    @PostMapping("/create")
    public String category(CategoryDTO categoryDTO) {
        categoryService.createCategory(categoryDTO);
        return "redirect:/category/create";
    }

    @GetMapping("/categoryList")
    public String findAllCategory(
            @RequestParam(name = "categoryNo", required = false) Integer categoryNo,
            @PageableDefault Pageable pageable,
            Model model) {

        log.info("pageable = {}", pageable);

        Page<CategoryDTO> categoryList;

        categoryList = categoryService.findAllCategory(pageable);
        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(categoryList);
        model.addAttribute("paging", paging);
        model.addAttribute("categoryList", categoryList);


        // num 값의 여부에 따른 처리
        if (categoryNo != null) {
            // categoryNo가 있을 경우 해당 카테고리만 조회
            CategoryDTO category = categoryService.findCategoryByNo(categoryNo);
//            categoryList = new PageImpl<>(Collections.singletonList(category)); // 단일 카테고리를 페이지로 감싸기
            model.addAttribute("category", category);
        }


        return "category/categoryList";
    }

    @GetMapping("/modify/{categoryNo}")
    public String modifyPage(@PathVariable int categoryNo, Model model) {

        CategoryDTO category = categoryService.findCategoryByNo(categoryNo);

        model.addAttribute("category", category);

        return "category/modify";
    }

    @PostMapping("/modify")
    public String modifyCategoryName(CategoryDTO modifyCategoryName) {

        categoryService.modifyCategoryName(modifyCategoryName);

        return "redirect:/category/categoryList";
    }

    @GetMapping("/delete")
    public void deletePage(){
    }

    @PostMapping("/delete")
    public String deleteCategoryName(@RequestParam Integer categoryNo) {

        categoryService.deleteCategoryName(categoryNo);

        return "redirect:/category/categoryList";
    }
}
