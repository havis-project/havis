package com.havis.object.post.model.entity;

import com.havis.common.basetime.entity.BaseTimeEntity;
import com.havis.object.category.model.entity.CategoryEntity;
import com.havis.object.member.model.entity.MemberEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_post")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class PostEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_no", nullable = false)
    @Comment("게시글번호")
    private int postNo;

    @Column(name = "post_title", nullable = false)
    @Comment("게시글제목")
    private String postTitle;

    @Column(name = "post_text", nullable = false)
    @Comment("게시글내용")
    private String postText;

    @Column(name = "post_date", nullable = false)
    @Comment("게시글작성일시")
    @CreatedDate
    private LocalDateTime postDate;

    @Column(name = "post_banned_date")
    @Comment("게시글정지일시")
    private LocalDateTime postBannedDate;

    @Column(name = "post_ban_end_date")
    @Comment("게시글정지해제일시")
    private LocalDateTime postBanEndDate;

    @ManyToOne
    @JoinColumn(name = "member_no")
    @Comment("게시글작성자")
    private MemberEntity member;

    @ManyToOne
    @JoinColumn(name = "category_no")
    @Comment("게시글카테고리")
    private CategoryEntity category;
    private LocalDateTime modifiedAt;
    private LocalDateTime createdAt;


    public void updatePostEntity(String postText) {

        this.postText = postText;



    }

    public void update(String postTitle, String postText) {

        this.postTitle = postTitle;
        this.postText = postText;

    }
}
