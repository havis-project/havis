package com.havis.object.post.model.entity;

import com.havis.object.category.model.entity.CategoryEntity;
import com.havis.object.member.model.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@ToString
public class PostRequestDTO {

    private int postNo;
    private String postTitle;
    private String postText;
    private LocalDateTime postDate;
    private LocalDateTime postBannedDate;
    private LocalDateTime postBanEndDate;
    private MemberEntity member;
    private CategoryEntity category;


}
