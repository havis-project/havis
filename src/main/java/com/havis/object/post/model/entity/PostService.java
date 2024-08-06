package com.havis.object.post.model.entity;

import com.havis.object.member.model.entity.MemberEntity;
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
    public PostResponseDTO createPost(PostRegisterDTO postRequestDTO) {
        PostEntity postEntity = new PostEntity(postRequestDTO);
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

    // 글 수정
    @Transactional
    public MemberEntity update(Long member, PostRequestDTO postRequestDTO) {
        PostEntity postEntity = postRepository.findById(member).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        postEntity.update(postRequestDTO);
        return postEntity.getMember();
    }

    // 삭제
    @Transactional
    public Long delete(Long member) {
        postRepository.deleteById(member);
        return member;
    }


    public List<PostEntity> getAllPost() {

        return postRepository.findAll();
    }
}
