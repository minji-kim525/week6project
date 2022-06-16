package com.sparta.week6project.dto.responseDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {
    Long id;
    @JsonFormat(pattern ="YYYY-MM-dd HH:mm")
    private LocalDateTime modifiedAt;
    private String nickname;
    private String content;

    public CommentResponseDto(Long id, String nickname, String content, LocalDateTime modifiedAt) {
        this.id = id;
        this.nickname = nickname;
        this.modifiedAt = modifiedAt;
        this.content = content;
    }
}