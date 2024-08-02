package com.havis.model.post.entity;

import com.havis.model.category.entity.CategoryEntity;
import com.havis.model.member.entity.MemberEntity;
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
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_no", nullable = false)
    private int postNo;

    @Column(name = "post_title", nullable = false)
    private String postTitle;

    @Column(name = "post_text", nullable = false)
    private String postText;

    @Column(name = "post_date", nullable = false)
    private LocalDateTime postDate;

    @Column(name = "post_banned_date")
    private LocalDateTime postBannedDate;

    @Column(name = "post_ban_end_date")
    private LocalDateTime postBanEndDate;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    @ManyToOne
    @JoinColumn(name = "category_name")
    private CategoryEntity category;
}
