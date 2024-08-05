package com.havis.object.member.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_member")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ToString
public class MemberEntity extends BaseTimeEntity {

    @Id
    @Column(name = "member_id", unique = true, nullable = false)
    private String memberId;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "nickname", unique = true, nullable = false)
    private String nickname;

    @Column(name = "level", nullable = false)
    @ColumnDefault(value = "1")
    private int level;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @Column(name = "phone", unique = true, nullable = false)
    private String phone;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "location")
    private String location;

    @Column(name = "ent_date", nullable = false)
    @CreatedDate
    private LocalDateTime entDate;

    @Column(name = "exit_date")
    private LocalDateTime exitDate;

    @Column(name = "banned_date")
    private LocalDateTime bannedDate;

    @Column(name = "ban_end_date")
    private LocalDateTime banEndDate;

    @Enumerated(EnumType.STRING)
    private RoleType role;
}
