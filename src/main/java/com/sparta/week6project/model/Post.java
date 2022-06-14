package com.sparta.week6project.model;

import com.sparta.week6project.dto.requestDto.PostDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Post extends Timestamped {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = true)
    private String imageUrl;

    public Post(User user, PostDto requestDto) {
        this.user = user;
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.imageUrl = requestDto.getImageUrl();
    }

    public void update(PostDto requestDto){
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.imageUrl = requestDto.getImageUrl();
    }

}
