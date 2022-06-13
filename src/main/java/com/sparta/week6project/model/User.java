package com.sparta.week6project.model;

import com.sparta.week6project.dto.requestDto.SignUpRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Setter
@Entity(name = "userinfo")
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private String profileImage;

    @Column(nullable = true,unique = true)
    private String email;

    @Column(nullable = false,unique = true)
    private String nickname;

    public User(SignUpRequestDto signUpRequestDto) {
        this.username = signUpRequestDto.getUsername();
        this.password = signUpRequestDto.getPassword();
        this.profileImage = signUpRequestDto.getProfileImage();
        this.email=signUpRequestDto.getEmail();
        this.nickname = signUpRequestDto.getNickname();
    }
}
