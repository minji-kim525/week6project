package com.sparta.week6project.dto.requestDto;

import lombok.Getter;

import java.util.List;

@Getter
public class PostRequestDto {

    private String title;
    private String content;
    private String imageUrl;
    private List<TagRequestDto> tags;


}
