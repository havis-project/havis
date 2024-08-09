package com.havis.object.member.service;

import com.havis.object.member.model.dto.SignupDTO;
import com.havis.object.member.model.entity.MemberEntity;
import com.havis.object.member.model.entity.RoleType;
import com.havis.object.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

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
                .email(signupDTO.getEmail())
                .name(signupDTO.getName())
                .phone("010-" + signupDTO.getFrontPhone() + "-" + signupDTO.getBackPhone())
                .birthday(signupDTO.getBirthday())
                .location(locationCheck(signupDTO))
                .level(1).role(RoleType.valueOf("USER")).build();

        log.info("[회원가입] 회원번호 : {}, id : {}", member.getMemberNo(), member.getMemberId());

        memberRepository.save(member);
    }

    private String locationCheck(SignupDTO signupDTO) {

        String sido = signupDTO.getSido();
        String sigugun = signupDTO.getSigugun();

        if (sido.equals("시/도 선택")) {
            return null;
        } else if (sigugun.equals("시/구/군 선택")) {
            return sido;
        } else {
            return sido + " " + sigugun;
        }
    }

    public MemberEntity findMemberById(String userId) {
        MemberEntity member = memberRepository.findMemberByMemberId(userId) // 로그인 되어있는 id로 회원정보 가져오기
                .orElseThrow(() -> new NoSuchElementException("회원정보를 찾을 수 없습니다.")); // 실패할 시 오류메세지 반환
        return member;
    }

    public void updateMemberInfo(String userId, SignupDTO signupDTO) {
        MemberEntity member = memberRepository.findMemberByMemberId(userId)
                .orElseThrow(() -> new NoSuchElementException("회원정보를 찾을 수 없습니다."));

        MemberEntity.MemberEntityBuilder builder = member.toBuilder(); // 기존 회원정보에 toBuilder 사용 정의

        if (!signupDTO.getPassword().isEmpty()) {
            builder.password(signupDTO.getPassword());
        }

        if (!signupDTO.getNickname().isEmpty()) {
            builder.nickname(signupDTO.getNickname());
        }

        if (!signupDTO.getEmail().isEmpty()) {
            builder.email(signupDTO.getEmail());
        }

        if (!signupDTO.getName().isEmpty()) {
            builder.name(signupDTO.getName());
        }

        if (!signupDTO.getFrontPhone().isEmpty() && !signupDTO.getBackPhone().isEmpty()) {
            builder.phone("010-" + signupDTO.getFrontPhone() + signupDTO.getBackPhone());
        }

        if (signupDTO.getBirthday() != null) {
            builder.birthday(signupDTO.getBirthday());
        }

        if (!signupDTO.getSido().equals("시/도 선택")) {
            builder.location(locationCheck(signupDTO));
        }

        MemberEntity updateMember = builder.build(); // 업데이트할 내용 build

        memberRepository.save(updateMember); // 업데이트한 정보 저장
    }
}
