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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

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
        return "redirect:/post/postList";
    }

    @GetMapping("/postDelete")
    public void postDelete() {
    }

    // 삭제
    @PostMapping("/postDelete")
    public String deletePost(@RequestParam Integer postNo) {

        postService.deletePost(postNo);

        return "redirect:/post/postList";
    }

    @GetMapping("/postUpdate")
    public void postUpdate() {
    }

//    @PostMapping("/postUpdate")
//    public String updatePost(@RequestParam Integer postNo, @RequestBody PostRegisterDTO postRegisterDTO) {
//
//        postService.updatePost(postNo, postRegisterDTO);
//
//        return "redirect:/post/postList";
//    }

    @PostMapping("/postUpdate")
    public RedirectView updatePost(@RequestParam Integer postNo,
                                   @RequestParam String postTitle,
                                   @RequestParam String postText) {

        log.info("postNo : {}", postNo);
        log.info("postTitle = {}", postTitle);
        log.info("postText = {}", postText);
        PostRegisterDTO postRegisterDTO = new PostRegisterDTO(postTitle, postText);
        postService.updatePost(postNo, postRegisterDTO);
        return new RedirectView("/post/postList");
    }

    // 전체 조회, 단건 조회
    @GetMapping("/postList")
    public String findAllPost(
            @RequestParam(name = "postNo", required = false) Integer postNo,
            @PageableDefault Pageable pageable,
            Model model) {

        log.info("pageable = {}", pageable);

        Page<PostRegisterDTO> postList;

        postList = postService.findAllPost(pageable);

        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(postList);

        model.addAttribute("paging", paging);
        model.addAttribute("postList", postList);

        if (postNo != null) {
            PostRegisterDTO postRegisterDTO = postService.findPostByNo(postNo);
            model.addAttribute("postList", postRegisterDTO);
        }

        return "post/postList";
    }

    @GetMapping("/postMain")
    public void postMain() {
    }

//    // 상세 조회
//    @GetMapping("/{postTitle}")
//    public String PostDetail(@PathVariable String postTitle, Model model) {
//
//        PostEntity postEntity = postService.findPostById(postTitle);
//
//        model.addAttribute("postEntity", postEntity);
//
//        return "post/postDetail";
//    }
}
