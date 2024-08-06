package com.havis.object.post.model.entity;


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
}
