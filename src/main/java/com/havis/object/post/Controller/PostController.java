package com.havis.object.post.Controller;


import com.havis.common.Pagenation;
import com.havis.common.PagingButtonInfo;
import com.havis.object.post.model.dto.PostRegisterDTO;
import com.havis.object.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("/postList")
    public String findAllPost(@PageableDefault Pageable pageable, Model model) {

        log.info("pageable = {}", pageable);

        Page<PostRegisterDTO> postList = postService.findAllPost(pageable);

        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(postList);

        model.addAttribute("paging", paging);
        model.addAttribute("postList", postList);

        return "post/postList";
    }


//    @PutMapping("/{member_id}")
//    public PostEntity updatePost(@PathVariable Long member, @RequestBody PostRegisterDTO updatedPost) {
//        return postService.updatePost(member, updatedPost);
//    }

    @DeleteMapping("/{member_id}")
    public void deletePost(@PathVariable Long member) {
        postService.deletePost(member);
    }


}
