package com.sparta.week6project.dto.requestDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PagesRequestDto {

    private int page;
    private int size;

}
