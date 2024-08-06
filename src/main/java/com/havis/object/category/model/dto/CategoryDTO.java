package com.havis.object.category.model.dto;

import com.havis.object.category.model.entity.CategoryEntity;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryDTO {

    private String category_name;
    private LocalDateTime categoryDate;
    private LocalDateTime categoryHideDate;

}
