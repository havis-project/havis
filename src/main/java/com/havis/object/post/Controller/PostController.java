package com.havis.object.post.Controller;


import com.havis.object.category.model.dto.CategoryDTO;
import com.havis.object.post.model.entity.PostEntity;
import com.havis.object.post.model.dto.PostRegisterDTO;
import com.havis.object.post.model.dto.PostResponseDTO;
import com.havis.object.post.service.PostService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.modeler.BaseAttributeFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/post")
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final PostService postService;

    @GetMapping("/create")
    public String post() {
        return "post/create";

    }


    @PostMapping("/create")
    public String post(PostRegisterDTO postRegisterDTO) {
        postService.createPost(postRegisterDTO);
        return "redirect:/";
    }

    @GetMapping("/view")
    public String postView() {
        return "post/create";

    }


    @PostMapping("/view")
    public String findAllPost(Model model) {


        model.addAttribute("list", postService.findAllPost());
        return "list";
    }

//    @PostMapping
//    public PostResponseDTO createPost(@RequestBody PostRegisterDTO postEntity) {
//        return postService.createPost(postEntity);
//    }

//    @PutMapping("/{member_id}")
//    public PostEntity updatePost(@PathVariable Long member, @RequestBody PostRegisterDTO updatedPost) {
//        return postService.updatePost(member, updatedPost);
//    }

    @DeleteMapping("/{member_id}")
    public void deletePost(@PathVariable Long member) {
        postService.deletePost(member);
    }


}
