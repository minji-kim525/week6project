package com.sparta.week6project.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DuplicationRequestDto {
    private String username;
    private String nickname;
    private String email;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DuplicationResponseDto {
        private String message;

    }
}