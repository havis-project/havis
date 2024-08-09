package com.havis.object.category.model.entity;

import com.havis.common.basetime.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_category")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@ToString
@Builder(toBuilder = true)
public class CategoryEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_no", unique = true, nullable = false, updatable = false)
    @Comment("카테고리번호")
    private int categoryNo;

    @Column(name = "category_name", unique = true, nullable = false)
    @Comment("카테고리명")
    private String categoryName;

    @Column(name = "category_date", updatable = false)
    @Comment("카테고리생성일시")
    @CreatedDate
    private LocalDateTime categoryDate;

    @Column(name = "category_hide_date")
    @Comment("카테고리숨김일시")
    private LocalDateTime categoryHideDate;


    // 카테고리명을 수정하는 메서드
    public void changeName(String newName) {
        this.categoryName = newName;
    }

}
