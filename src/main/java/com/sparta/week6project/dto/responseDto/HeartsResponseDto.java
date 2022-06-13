package com.sparta.week6project.dto.responseDto;

import lombok.Getter;

@Getter
public class HeartsResponseDto {
    private Boolean isheart;

    public HeartsResponseDto(Boolean isheart) {

        this.isheart = isheart;
    }
}
