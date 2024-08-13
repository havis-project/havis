package com.havis.object.post.model.dto;

import com.havis.object.category.model.entity.CategoryEntity;
import com.havis.object.member.model.entity.MemberEntity;
import com.havis.object.post.model.entity.PostEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@Setter
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

    public PostRegisterDTO(String postTitle, String postText) {
        this.postTitle = postTitle;
        this.postText = postText;
    }


}
