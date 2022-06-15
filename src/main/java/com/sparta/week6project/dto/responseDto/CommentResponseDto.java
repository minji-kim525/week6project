package com.sparta.week6project.dto.responseDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {
    @JsonFormat(pattern ="YYYY-MM-dd HH:mm")
    private LocalDateTime modifiedAt;
    private String nickname;
    private String content;

    public CommentResponseDto(String nickname, String content, LocalDateTime modifiedAt) {
        this.nickname = nickname;
        this.modifiedAt = modifiedAt;
        this.content = content;
    }
}