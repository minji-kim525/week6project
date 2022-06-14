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
    private String fileName;
    private List<TagRequestDto> tags;


    public void setImageUrlAndFileName(FileRequestDto requestDto) {
        this.imageUrl = requestDto.getImageUrl();
        this.fileName = requestDto.getFileName();
    }
}
