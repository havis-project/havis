package com.havis.model.member.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_member")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberEntity {

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

    @Column(name = "member_name", nullable = false)
    private String memberName;

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
    private LocalDateTime entDate;

    @Column(name = "exit_date")
    private LocalDateTime exitDate;

    @Column(name = "banned_date")
    private LocalDateTime bannedDate;

    @Column(name = "ban_end_date")
    private LocalDateTime banEndDate;
}
