package com.havis.object.category.model.dto;

import com.havis.object.category.model.entity.CategoryEntity;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CategoryDTO {

    private String categoryName;
}
