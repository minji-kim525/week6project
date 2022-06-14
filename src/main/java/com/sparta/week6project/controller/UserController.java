package com.sparta.week6project.controller;

import com.sparta.week6project.dto.requestDto.DuplicationRequestDto;
import com.sparta.week6project.dto.requestDto.LoginRequestDto;
import com.sparta.week6project.dto.requestDto.SignUpRequestDto;
import com.sparta.week6project.dto.responseDto.LoginResponseDto;
import com.sparta.week6project.dto.responseDto.SignUpResponseDto;
import com.sparta.week6project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user/signup")
    public ResponseEntity<SignUpResponseDto> registerUser(@RequestBody SignUpRequestDto signUpRequestDto){
        return ResponseEntity.ok().body(userService.registerUser(signUpRequestDto));
    }

    @PostMapping("/user/login")
    public ResponseEntity<LoginResponseDto> loginUser(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response){;
        return userService.loginUser(loginRequestDto);

    }

    //HttpServletResponse response
    //response.addHeader("X-AUTH-TOKEN", loginResponseDto.getToken());

    @PostMapping("/user/signup/duplicate")
    public ResponseEntity<SignUpResponseDto> duplicationCheck(@RequestBody DuplicationRequestDto duplicationRequestDto){
        return userService.duplicationCheck(duplicationRequestDto);
    }

//    @GetMapping("/user/logout")
//    public void logoutUser(){
//
//    }
}
