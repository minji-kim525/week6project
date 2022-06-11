package com.sparta.week6project.model;

import com.sparta.week6project.dto.requestDto.TagRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Tag {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postId")
    private Post post;

    @Column(nullable = false)
    private String tag;

    public Tag(Post post, TagRequestDto tagRequestDto){
        this.post = post;
        this.tag = tagRequestDto.getTag();
    }

}
