package com.havis.object.member.model.dto;

import lombok.*;

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
    private String frontPhone;
    private String backPhone;

    private String sido;
    private String sigugun;
}
