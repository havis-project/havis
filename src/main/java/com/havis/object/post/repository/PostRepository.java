package com.havis.object.post.repository;

import com.havis.object.post.model.dto.PostRegisterDTO;
import com.havis.object.post.model.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

}
