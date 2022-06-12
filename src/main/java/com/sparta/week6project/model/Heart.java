package com.sparta.week6project.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Heart {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postId")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @Column(nullable = false)
    private boolean isheart = false;

    public Heart(Post post, User user) {
        this.post = post;
        this.user = user;
        setIsheart();
    }

    public void setIsheart() {
        this.isheart = !this.isheart;
    }
}
