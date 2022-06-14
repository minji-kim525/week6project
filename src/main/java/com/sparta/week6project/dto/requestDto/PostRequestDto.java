package com.sparta.week6project.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PostRequestDto {

    private String title;
    private String content;
    private String imageUrl;
    private List<TagRequestDto> tags;


}
