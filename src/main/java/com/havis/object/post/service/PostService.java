package com.havis.object.post.service;

import com.havis.object.category.model.dto.CategoryDTO;
import com.havis.object.category.model.entity.CategoryEntity;
import com.havis.object.post.model.dto.PostRegisterDTO;
import com.havis.object.post.model.entity.PostEntity;
import com.havis.object.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.ModelMapper;

import static java.lang.Long.valueOf;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    // 글 생성
    public void createPost(PostRegisterDTO postRegisterDTO) {
        PostEntity postEntity = PostEntity.builder()
                .postTitle(postRegisterDTO.getPostTitle())
                .postText(postRegisterDTO.getPostText())
                .build();

        log.info("[카테고리생성] 카테고리명 : {}", postEntity.getPostTitle());

        postRepository.saveAndFlush(postEntity);
    }

    // 전체 조회
    public Page<PostRegisterDTO> findAllPost(Pageable pageable) {

        pageable = PageRequest.of(
                pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("postNo").descending());

        Page<PostEntity> postList = postRepository.findAll(pageable);

        return postList.map(postEntity -> modelMapper.map(postEntity, PostRegisterDTO.class));

    }

    // 단건 조회
    public PostRegisterDTO findPostByNo(int postNo) {

        PostEntity postEntity = postRepository.findById(postNo)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다."));

        return modelMapper.map(postEntity, PostRegisterDTO.class);

    }




    // 삭제
    @Transactional
    public void deletePost(Integer postNo) {

            postRepository.deleteById(postNo);


    }

    // 수정
    @Transactional
    public void updatePost(Integer postNo, PostRegisterDTO postRegisterDTO){

        PostEntity postEntity = postRepository.findById(postNo)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id = "+postNo));

        log.info("service postRegisterDTO postTitle: {}", postRegisterDTO.getPostTitle());
        log.info("service postRegisterDTO postText: {}", postRegisterDTO.getPostText());
        postEntity.setPostTitle(postRegisterDTO.getPostTitle());
        postEntity.setPostText(postRegisterDTO.getPostText());


        postRepository.save(postEntity);



    }



}
