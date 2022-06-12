package com.sparta.week6project.dto.responseDto;

import lombok.Getter;

@Getter
public class HeartsResponseDto {
    private boolean isheart;

    public HeartsResponseDto(boolean isheart) {

        this.isheart = isheart;
    }
}
