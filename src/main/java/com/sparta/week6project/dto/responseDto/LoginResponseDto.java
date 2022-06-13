package com.sparta.week6project.dto.responseDto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponseDto {
    //token, ok, message
    @JsonIgnore
    private String token;
    private boolean ok;
    private String message;
}

