package com.havis.object.post.service;

import com.havis.object.post.model.dto.PostRegisterDTO;
import com.havis.object.post.model.dto.PostResponseDTO;
import com.havis.object.post.model.entity.PostEntity;
import com.havis.object.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {

    private final PostRepository postRepository;
//
//    public void createCategory(CategoryDTO categoryDTO) {
//
//        CategoryEntity category = CategoryEntity.builder()
//                .categoryName(categoryDTO.getCategoryName())
//                .build();
//
//        log.info("[카테고리생성] 카테고리명 : {}", category.getCategoryName());
//
//        categoryRepository.saveAndFlush(category);
//    }

    // 글 생성
    public void createPost(PostRegisterDTO postRegisterDTO) {
        PostEntity postEntity = PostEntity.builder()
                .postTitle(postRegisterDTO.getPostTitle())
                .postText(postRegisterDTO.getPostText())
                .build();

        log.info("[카테고리생성] 카테고리명 : {}", postEntity.getPostTitle());

        postRepository.saveAndFlush(postEntity);
    }

    // 모든 글 가져오기
    public List<PostEntity> findAllPost() {
        try{
            List<PostEntity> postEntityList = postRepository.findAll();

            List<PostResponseDTO> postResponseDTOList = new ArrayList<>();

            for (PostEntity postEntity : postEntityList) {
                postResponseDTOList.add(
                        new PostResponseDTO(postEntity)
                );

            }


        } catch (Exception e) {

        }

        return null;
    }



    // 삭제
    @Transactional
    public Long deletePost(Long member) {
        postRepository.deleteById(member);
        return member;
    }

//    @Transactional
//    public PostEntity updatePost(Long member, PostRegisterDTO updatedPost) {
//        PostEntity post = postRepository.findById(member).orElseThrow(() -> new IllegalArgumentException("잘못된 Post 입니다."));
//        post.update(updatedPost.getPostTitle(), post.getPostText());
//
//        return postRepository.save(post);
//    }

}
