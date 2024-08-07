package com.havis.object.member.service;

import com.havis.object.member.model.dto.SignupDTO;
import com.havis.object.member.model.entity.MemberEntity;
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
                .password(passwordEncoder.encode(signupDTO.getPassword()))
                .nickname(signupDTO.getNickname())
                .name(signupDTO.getName())
                .gender(signupDTO.getGender())
                .birthday(signupDTO.getBirthday())
                .phone(signupDTO.getPhone())
                .email(signupDTO.getEmail())
                .location(signupDTO.getLocation())
                .build();

        log.info("[회원가입] id : {}", member.getMemberId());

        MemberEntity newMember = memberRepository.save(member);
    }
}
