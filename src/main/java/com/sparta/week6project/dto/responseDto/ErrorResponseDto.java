package com.sparta.week6project.dto.responseDto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponseDto {
    String token;
    private boolean ok;
    private String message;

    public ErrorResponseDto (boolean ok, String message) {
        this.ok = ok;
        this.message = message;
    }
}
