package com.sparta.week6project.dto.responseDto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpResponseDto {


    private boolean ok;
    private String message;

//    public void successSignup(){
//        this.ok=true;
//        this.message="회원가입 성공";
//    }
}
