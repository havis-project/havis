package com.havis.object.member.service;

import com.havis.object.member.model.dto.SignupDTO;
import com.havis.object.member.model.entity.MemberEntity;
import com.havis.object.member.model.entity.RoleType;
import com.havis.object.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public void register(SignupDTO signupDTO) {

        MemberEntity member = MemberEntity.builder()
                .memberId(signupDTO.getMemberId())
                .password(signupDTO.getPassword())
                .nickname(signupDTO.getNickname())
                .name(signupDTO.getName())
                .gender(signupDTO.getGender())
                .birthday(signupDTO.getBirthday())
                .phone("010" + signupDTO.getFrontPhone() + signupDTO.getBackPhone())
                .email(signupDTO.getEmailId() + "@" + signupDTO.getEmailSelect())
                .location(signupDTO.getSido() + " " + signupDTO.getGugun())
                .level(1)
                .role(RoleType.valueOf("USER"))
                .build();

        log.info("[회원가입] 회원번호 : {}, id : {}", member.getMemberNo(), member.getMemberId());

        memberRepository.saveAndFlush(member);
    }
}
