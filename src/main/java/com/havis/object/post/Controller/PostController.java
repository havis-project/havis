package com.havis.object.post.Controller;


import com.havis.object.post.model.entity.PostEntity;
import com.havis.object.post.model.dto.PostRegisterDTO;
import com.havis.object.post.model.dto.PostResponseDTO;
import com.havis.object.post.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<PostEntity> findAllPost() {
        return postService.findAllPost();
    }

    @PostMapping
    public PostResponseDTO createPost(@RequestBody PostRegisterDTO postEntity) {
        return postService.createPost(postEntity);
    }

    @PutMapping("/{member_id}")
    public PostEntity updatePost(@PathVariable Long member, @RequestBody PostRegisterDTO updatedPost) {
        return postService.updatePost(member, updatedPost);
    }

    @DeleteMapping("/{member_id}")
    public void deletePost(@PathVariable Long member) {
        postService.deletePost(member);
    }


}
