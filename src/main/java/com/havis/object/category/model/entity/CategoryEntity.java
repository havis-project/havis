package com.havis.object.category.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_category")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_name", nullable = false)
    private String categoryName;

    @Column(name = "category_date")
    private LocalDateTime categoryDate;

    @Column(name = "category_hide_date")
    private LocalDateTime categoryHideDate;
}
