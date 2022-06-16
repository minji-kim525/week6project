package com.sparta.week6project.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DuplicationRequestDto {
    @NotNull(message = "아이디를 입력해주세요")
    @Pattern(regexp = "^[a-z][a-z0-9]{5,11}$",message = "아이디 형식이 올바르지 않습니다.")
    private String username;
//    private String nickname;
//    private String email;
}