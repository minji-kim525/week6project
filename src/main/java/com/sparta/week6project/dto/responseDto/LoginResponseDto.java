package com.sparta.week6project.dto.responseDto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponseDto {
    //token, ok, message
    private String token;
    private boolean ok;
    private String message;
}

