package com.sparta.week6project.dto.responseDto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {
    private LocalDateTime modifiedAt;
    private String nickname;
    private String contents;

    public CommentResponseDto(String nickname, String contents, LocalDateTime modifiedAt) {
        this.nickname = nickname;
        this.modifiedAt = modifiedAt;
        this.contents = contents;
    }
}