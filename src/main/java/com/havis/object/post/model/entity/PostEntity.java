package com.havis.object.post.model.entity;

import com.havis.object.category.model.entity.CategoryEntity;
import com.havis.object.member.model.entity.MemberEntity;
import com.havis.object.post.model.dto.PostRegisterDTO;
import com.havis.object.post.model.dto.PostRequestDTO;
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
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
    private LocalDateTime modifiedAt;
    private LocalDateTime createdAt;

    public PostEntity(PostRegisterDTO postRequestDTO) {

        this.postNo = postRequestDTO.getPostNo();
        this.postTitle = postRequestDTO.getPostTitle();
        this.postText = postRequestDTO.getPostText();
        this.postDate = postRequestDTO.getPostDate();
        this.postBannedDate = postRequestDTO.getPostBannedDate();
        this.postBanEndDate = postRequestDTO.getPostBanEndDate();
        this.member = postRequestDTO.getMember();
        this.category = postRequestDTO.getCategory();



    }

    public PostEntity(String postTitle, String postText) {
    }

    public void updatePost(PostRequestDTO postRequestDTO) {
        this.postNo = postRequestDTO.getPostNo();
        this.postTitle = postRequestDTO.getPostTitle();
        this.postText = postRequestDTO.getPostText();
        this.postDate = postRequestDTO.getPostDate();
        this.postBannedDate = postRequestDTO.getPostBannedDate();
        this.postBanEndDate = postRequestDTO.getPostBanEndDate();
        this.member = postRequestDTO.getMember();
        this.category = postRequestDTO.getCategory();


    }



    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public void update(String postTitle, String postText) {
    }
}
