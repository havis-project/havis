package com.havis.object.post.service;

import com.havis.object.member.model.entity.MemberEntity;
import com.havis.object.post.model.dto.PostRegisterDTO;
import com.havis.object.post.model.dto.PostRequestDTO;
import com.havis.object.post.model.dto.PostResponseDTO;
import com.havis.object.post.model.entity.PostEntity;
import com.havis.object.post.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PostService {

    private final PostRepository postRepository;



    // 글 생성
    public PostResponseDTO createPost(PostRegisterDTO postRegisterDTO) {
        PostEntity postEntity = new PostEntity(postRegisterDTO);
        postRepository.save(postEntity);
        return new PostResponseDTO(postEntity);
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

    @Transactional
    public PostEntity updatePost(Long member, PostRegisterDTO updatedPost) {
        PostEntity post = postRepository.findById(member).orElseThrow(() -> new IllegalArgumentException("잘못된 Post 입니다."));
        post.update(updatedPost.getPostTitle(), post.getPostText());

        return postRepository.save(post);
    }

}
