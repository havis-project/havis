package com.havis.object.post.model.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

    List<PostListResponseDTO> findAllByOrderByModifiedAtDesc();


}
