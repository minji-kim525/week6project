package com.sparta.week6project.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FileRequestDto {

    private String imageUrl;
    private String fileName;

}
