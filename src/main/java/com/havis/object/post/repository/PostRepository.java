package com.havis.object.post.repository;

import com.havis.object.post.model.dto.PostRegisterDTO;
import com.havis.object.post.model.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Integer> {

//    Optional<Object> findById(String postTitle);
}
