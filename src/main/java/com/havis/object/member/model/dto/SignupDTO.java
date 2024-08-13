package com.havis.object.member.model.dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SignupDTO {

    private String memberId;

    private String password;
    private String pwCheck;

    private String nickname;

    private String email;

    private String name;

    private String phone;

    private LocalDate birthday;

    private String sido;
    private String sigugun;
}
