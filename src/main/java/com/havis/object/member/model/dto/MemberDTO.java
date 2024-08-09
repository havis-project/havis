package com.havis.object.member.model.dto;

import com.havis.object.member.model.entity.RoleType;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberDTO {

    private int memberNo;
    private String memberId;
    private String password;
    private String nickname;
    private int level;
    private String name;
    private String phone;
    private LocalDate birthday;
    private String email;
    private String location;
    private LocalDateTime exitDate;
    private LocalDateTime bannedDate;
    private LocalDateTime banEndDate;
    private RoleType role;
}
