package com.sparta.week6project.controller;

import com.sparta.week6project.dto.requestDto.SignupRequestDto;
import com.sparta.week6project.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    // 회원 가입
    @PostMapping("/user/signup")
    public String registerUser(@RequestBody SignupRequestDto requestDto){
        return userService.registerUser(requestDto);
    }

}