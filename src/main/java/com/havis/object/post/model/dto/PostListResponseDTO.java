package com.havis.object.post.model.dto;

import com.havis.object.post.model.entity.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PostListResponseDTO {

    // 제목
    private String postTitle;

    // 작성자명
    private String username;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

    // Entity -> dto
    public PostListResponseDTO(PostEntity postEntity) {
        this.postTitle = postEntity.getPostTitle();
        this.createdAt = postEntity.getModifiedAt();
        this.modifiedAt = postEntity.getCreatedAt();
    }

    public PostListResponseDTO(Optional<PostEntity> postEntity) {
        this.postTitle = postEntity.get().getPostTitle();
        this.createdAt = postEntity.get().getModifiedAt();
        this.modifiedAt = postEntity.get().getCreatedAt();
    }


}
