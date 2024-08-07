package com.havis.object.post.model.dto;

import com.havis.object.category.model.entity.CategoryEntity;
import com.havis.object.member.model.entity.MemberEntity;
import com.havis.object.post.model.entity.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@ToString
public class PostResponseDTO {

    private int postNo;
    private String postTitle;
    private String postText;
    private LocalDateTime postDate;
    private LocalDateTime postBannedDate;
    private LocalDateTime postBanEndDate;
    private MemberEntity member;
    private CategoryEntity category;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public PostResponseDTO(PostEntity postEntity) {

        this.postNo = postEntity.getPostNo();
        this.postTitle = postEntity.getPostTitle();
        this.postText = postEntity.getPostText();
        this.postDate = postEntity.getPostDate();
        this.postBannedDate = postEntity.getPostBannedDate();
        this.postBanEndDate = postEntity.getPostBanEndDate();
        this.member = postEntity.getMember();
        this.category = postEntity.getCategory();
        this.modifiedAt = postEntity.getModifiedAt();
        this.createdAt = postEntity.getCreatedAt();



    }





}
