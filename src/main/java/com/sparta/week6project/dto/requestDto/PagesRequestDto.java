package com.sparta.week6project.dto.requestDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PagesRequestDto {

    private int page; // 필요 페이지 번호
    private int size; // 한 페이지당 게시글 수

}
