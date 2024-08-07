package com.havis.object.category.model.entity;

import com.havis.object.basetime.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_category")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CategoryEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "category_name", nullable = false)
    private String categoryName;

    @Column(name = "category_date")
    @CreatedDate
    private LocalDateTime categoryDate;

    @Column(name = "category_hide_date")
    private LocalDateTime categoryHideDate;
}
