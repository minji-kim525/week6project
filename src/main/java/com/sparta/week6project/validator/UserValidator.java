package com.sparta.week6project.validator;

import com.sparta.week6project.dto.requestDto.LoginRequestDto;
import com.sparta.week6project.dto.requestDto.SignUpRequestDto;
import com.sparta.week6project.exception.LoginIdNotValidException;
import com.sparta.week6project.exception.LoginPasswordNotValidException;
import com.sparta.week6project.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.regex.Pattern;

@Component
public class UserValidator {

    // 아이디 중복 검사
    public static void idDuplicationValidator(Optional<User> foundUsername) {
        if (foundUsername.isPresent()) {
            throw new IllegalArgumentException("중복된 아이디가 존재합니다.");
        }
    }
    // 닉네임 중복 검사
    public static void nicknameDuplicationValidator(Optional<User> foundNickname) {
        if (foundNickname.isPresent()) {
            throw new IllegalArgumentException("중복된 닉네임이 존재합니다.");
        }
    }
    // 이메일 중복 검사
    public static void emailDuplicationValidator(Optional<User> foundEmail) {
        if (foundEmail.isPresent()) {
            throw new IllegalArgumentException("중복된 이메일이 존재합니다.");
        }
    }
    // 비밀번호 형식 검사
    public static void passwordCheackValidator(SignUpRequestDto signupRequestDto) {
        if (!signupRequestDto.getPassword().equals(signupRequestDto.getPasswordCheck())) {
            throw new IllegalArgumentException("패스워드가 일치하지 않습니다.");
        }
        if (!Pattern.matches("^(?=.*[a-zA-Z])((?=.*\\d)(?=.*\\W)).{8,16}$", signupRequestDto.getPassword())) {
                throw new IllegalArgumentException("비밀번호 형식이 올바르지 않습니다.");
        }

        if (signupRequestDto.getPassword().contains(signupRequestDto.getUsername())) {
            throw new IllegalArgumentException("비밀번호에 아이디와 같은 값을 포함할 수 없습니다.");
        }
    }
    // 아이디 형식 검사
    public static void idCheackValidator(SignUpRequestDto signupRequestDto) {
        if (!Pattern.matches("^[a-z][a-z0-9]{5,11}$", signupRequestDto.getUsername())) {
            throw new IllegalArgumentException("아이디 형식이 올바르지 않습니다.");
        }
    }
    // 닉네임 형식 검사
    public static void nicknameCheackValidator(SignUpRequestDto signupRequestDto) {
        if(signupRequestDto.getNickname().length()<2||signupRequestDto.getNickname().length()>10){
            throw new IllegalArgumentException("닉네임 형식이 올바르지 않습니다.");
        }
    }
    // 이메일 형식 검사
    public static void emailCheackValidator(SignUpRequestDto signupRequestDto) {
        if (!Pattern.matches("^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$", signupRequestDto.getEmail())) {
            throw new IllegalArgumentException("이메일 형식이 올바르지 않습니다.");
        }
    }


    //로그인 유효성 검사
    public static void loginCheck(Optional<User> foundUsername, LoginRequestDto loginRequestDto, PasswordEncoder passwordEncoder) {
        if (!foundUsername.isPresent()) {
            throw new LoginIdNotValidException();
        }
        if (!passwordEncoder.matches(loginRequestDto.getPassword(),foundUsername.get().getPassword())) {
            throw new LoginPasswordNotValidException();
        }
    }
}
