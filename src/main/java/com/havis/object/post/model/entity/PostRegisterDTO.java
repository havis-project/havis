package com.havis.object.post.model.entity;

import com.havis.object.category.model.entity.CategoryEntity;
import com.havis.object.member.model.entity.MemberEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PostRegisterDTO {

    private int postNo;
    private String postTitle;
    private String postText;
    private LocalDateTime postDate;
    private LocalDateTime postBannedDate;
    private LocalDateTime postBanEndDate;
    private MemberEntity member;
    private CategoryEntity category;

    public PostEntity toEntity() {
        return new PostEntity(postTitle, postText);
    }



}
