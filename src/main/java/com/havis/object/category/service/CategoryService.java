package com.havis.object.category.service;

import com.havis.object.category.model.dto.CategoryDTO;
import com.havis.object.category.model.entity.CategoryEntity;
import com.havis.object.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public void createCategory(CategoryDTO categoryDTO) {

        CategoryEntity category = CategoryEntity.builder()
                .categoryName(categoryDTO.getCategoryName())
                .build();

        log.info("[카테고리생성] 카테고리명 : {}", category.getCategoryName());

        categoryRepository.saveAndFlush(category);
    }

    public Page<CategoryDTO> findAllCategory(Pageable pageable) {

        pageable = PageRequest.of(
                pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("categoryNo").descending());

        Page<CategoryEntity> categoryList = categoryRepository.findAll(pageable);

        return categoryList.map(categoryEntity -> modelMapper.map(categoryEntity, CategoryDTO.class));

    }

    public CategoryDTO findCategoryByNo(int categoryNo) {

        CategoryEntity category = categoryRepository.findById((long) categoryNo)
                .orElseThrow(IllegalArgumentException::new);

        return modelMapper.map(category, CategoryDTO.class);
        }
}
