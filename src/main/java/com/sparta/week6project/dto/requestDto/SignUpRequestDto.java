package com.sparta.week6project.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequestDto {
    @NotNull(message = "아이디를 입력해주세요")
    @Pattern(regexp = "^[a-z][a-z0-9]{5,11}$",message = "아이디 형식이 올바르지 않습니다.")
    private String username;

    @NotNull
    @Pattern(regexp = "^(?=.*[a-zA-Z])((?=.*\\d)(?=.*\\W)).{8,16}$", message = "비밀번호 형식이 올바르지 않습니다.")
    private String password;

    @NotNull
    private String passwordCheck;
    private String profileImage;

    @Email(message="이메일 형식이 올바르지 않습니다.")// @Email은 null 허용, 빈문자열 "" true , 공백" " false
    private String email;

    @NotNull
    @NotBlank
    @Length(min=2,max=10,message="닉네임 형식이 올바르지 않습니다.")
    private String nickname;

}