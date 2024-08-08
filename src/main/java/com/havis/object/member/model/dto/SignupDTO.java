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
    private String nickname;
    private String name;
    private String gender;
    private LocalDate birthday;
    private String phone;
    private String emailId;
    private String emailSelect;
    private String sido;
    private String gugun;
}
