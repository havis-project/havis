package com.havis.object.post.Controller;


import com.havis.common.Pagenation;
import com.havis.common.PagingButtonInfo;
import com.havis.object.post.model.dto.PostRegisterDTO;
import com.havis.object.post.model.entity.PostEntity;
import com.havis.object.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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

    @GetMapping("/postCreate")
    public String post() {
        return "post/postCreate";

    }


    @PostMapping("/postCreate")
    public String post(PostRegisterDTO postRegisterDTO) {
        postService.createPost(postRegisterDTO);
        return "redirect:/";
    }

    // 전체 조회
    @GetMapping("/postList")
    public String findAllPost(@PageableDefault Pageable pageable, Model model) {

        log.info("pageable = {}", pageable);

        Page<PostRegisterDTO> postList = postService.findAllPost(pageable);

        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(postList);

        model.addAttribute("paging", paging);
        model.addAttribute("postList", postList);

        return "post/postList";
    }

    // 상세 조회
    @GetMapping("/{postTitle}")
    public String PostDetail(@PathVariable String postTitle, Model model) {

        PostEntity postEntity = postService.findPostById(postTitle);

        model.addAttribute("postEntity", postEntity);

        return "post/postDetail";
    }


    // 수정
    @PutMapping("/postModify")
    public ResponseEntity<Boolean> updatePost(@RequestBody PostRegisterDTO postRegisterDTO){
        try{
            postService.updatePost(postRegisterDTO);
        }catch (Exception e){
            return ResponseEntity.ok(false);
        }

        return ResponseEntity.ok(true);
    }


    @DeleteMapping("/{member_id}")
    public void deletePost(@PathVariable Long member) {
        postService.deletePost(member);
    }


}
