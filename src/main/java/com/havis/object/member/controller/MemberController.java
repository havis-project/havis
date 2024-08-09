package com.havis.object.member.controller;

import com.havis.object.member.model.dto.SignupDTO;
import com.havis.object.member.model.dto.MemberUpdateDTO;
import com.havis.object.member.model.entity.MemberEntity;
import com.havis.object.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    // 회원가입 페이지로 이동
    @GetMapping("/register")
    public String register() {
        return "member/register";
    }

    @PostMapping("/register")
    public String register(SignupDTO signupDTO) {
        memberService.register(signupDTO);
        return "redirect:/";
    }

    // 마이페이지로 이동
    @GetMapping("/mypage")
    public String getMemberInfo(@AuthenticationPrincipal UserDetails user, Model model) {
        String userId = user.getUsername(); // 현재 로그인되어있는 유저 아이디 가져오기
        MemberEntity member = memberService.findMemberById(userId); // 아이디로 엔티티 찾아옴
        model.addAttribute("member", member); // model에 가져온 엔티티 담아서 넘겨주기
        return "member/mypage";
    }

    // 정보수정 페이지로 이동
    @GetMapping("/edit")
    public String editMemberInfo(@AuthenticationPrincipal UserDetails user, Model model) {
        String userId = user.getUsername(); // 현재 로그인되어있는 유저 아이디 가져오기
        MemberEntity member = memberService.findMemberById(userId); // 아이디로 엔티티 찾아옴
        model.addAttribute("member", member); // model에 가져온 엔티티 담아서 넘겨주기
        return "member/edit";
    }

    @PostMapping("/edit")
    public String updateMemberInfo(@AuthenticationPrincipal UserDetails user, MemberUpdateDTO memberUpdateDTO) {
        memberService.updateMemberInfo(user.getUsername(), memberUpdateDTO);
        return "redirect:/member/mypage";
    }
}
