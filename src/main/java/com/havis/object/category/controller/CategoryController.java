package com.havis.object.category.controller;

import com.havis.common.Pagenation;
import com.havis.common.PagingButtonInfo;
import com.havis.object.category.model.dto.CategoryDTO;
import com.havis.object.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public String findAllCategory(@PageableDefault Pageable pageable, Model model) {

        log.info("pageable = {}", pageable);

        Page<CategoryDTO> categoryList = categoryService.findAllCategory(pageable);

        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(categoryList);

        model.addAttribute("paging", paging);
        model.addAttribute("categoryList", categoryList);

        return "category/categoryList";
    }

    @GetMapping("/search")
    public String findByCategoryNo(@RequestParam Integer categoryNo, Model model){

        List<CategoryDTO> categoryList = categoryService.findCategoryByNo(categoryNo);

        model.addAttribute("")
    }
}
