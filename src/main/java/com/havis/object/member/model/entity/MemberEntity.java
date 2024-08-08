package com.havis.object.member.model.entity;

import com.havis.common.basetime.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@ToString
@Builder
public class MemberEntity extends BaseTimeEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_no", unique = true, nullable = false, updatable = false)
    @Comment("회원번호")
    private int memberNo;

    @Id
    @Column(name = "member_id", unique = true, nullable = false, updatable = false)
    @Comment("아이디")
    private String memberId;

    @Column(name = "password", nullable = false)
    @Comment("비밀번호")
    private String password;

    @Column(name = "nickname", unique = true, nullable = false)
    @Comment("닉네임")
    private String nickname;

    @Column(name = "level", nullable = false)
    @Comment("레벨")
    private int level;

    @Column(name = "name", nullable = false)
    @Comment("회원명")
    private String name;

    @Column(name = "phone", unique = true, nullable = false)
    @Comment("휴대폰번호")
    private String phone;

    @Column(name = "email", unique = true)
    @Comment("이메일")
    private String email;

    @Column(name = "location")
    @Comment("활동지")
    private String location;

    @Column(name = "ent_date", nullable = false, updatable = false)
    @Comment("가입일시")
    @CreatedDate
    private LocalDateTime entDate;

    @Column(name = "exit_date")
    @Comment("탈퇴일시")
    private LocalDateTime exitDate;

    @Column(name = "banned_date")
    @Comment("정지일시")
    private LocalDateTime bannedDate;

    @Column(name = "ban_end_date")
    @Comment("정지해제일시")
    private LocalDateTime banEndDate;

    @Enumerated(EnumType.STRING)
    @Comment("역할")
    private RoleType role;
}
