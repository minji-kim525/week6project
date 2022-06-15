package com.sparta.week6project.service;

import com.sparta.week6project.dto.requestDto.DuplicationRequestDto;
import com.sparta.week6project.dto.requestDto.LoginRequestDto;
import com.sparta.week6project.dto.requestDto.SignUpRequestDto;
import com.sparta.week6project.dto.responseDto.LoginResponseDto;
import com.sparta.week6project.dto.responseDto.SignUpResponseDto;
import com.sparta.week6project.model.User;
import com.sparta.week6project.repository.UserRepository;
import com.sparta.week6project.security.JwtTokenProvider;
import com.sparta.week6project.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    // 회원가입
    public SignUpResponseDto registerUser(SignUpRequestDto signUpRequestDto) {
        if(signUpRequestDto.getEmail()!=null) {
            Optional<User> foundUsername = userRepository.findByUsername(signUpRequestDto.getUsername());
            Optional<User> foundNickname = userRepository.findByNickname(signUpRequestDto.getNickname());
            Optional<User> foundEmail = userRepository.findByEmail(signUpRequestDto.getEmail());

            try {
                UserValidator.idDuplicationValidator(foundUsername);
                UserValidator.nicknameDuplicationValidator(foundNickname);
                UserValidator.emailDuplicationValidator(foundEmail);
                UserValidator.idCheackValidator(signUpRequestDto);
                UserValidator.emailCheackValidator(signUpRequestDto);
                UserValidator.nicknameCheackValidator(signUpRequestDto);
                UserValidator.passwordCheackValidator(signUpRequestDto);

            } catch (IllegalArgumentException e) {
                throw e;
            }
        }else {
            Optional<User> foundUsername = userRepository.findByUsername(signUpRequestDto.getUsername());
            Optional<User> foundNickname = userRepository.findByNickname(signUpRequestDto.getNickname());
            try {
                UserValidator.idDuplicationValidator(foundUsername);
                UserValidator.nicknameDuplicationValidator(foundNickname);
                UserValidator.idCheackValidator(signUpRequestDto);
                UserValidator.nicknameCheackValidator(signUpRequestDto);
                UserValidator.passwordCheackValidator(signUpRequestDto);
            } catch (IllegalArgumentException e) {
                throw e;
            }
        }
        signUpRequestDto.setPassword(passwordEncoder.encode(signUpRequestDto.getPassword()));
        User user = new User(signUpRequestDto);
        userRepository.save(user);
        return new SignUpResponseDto(true, "회원가입 성공");
    }

    // 로그인
    public LoginResponseDto loginUser(LoginRequestDto loginRequestDto) {
        Optional<User> foundUsername = userRepository.findByUsername(loginRequestDto.getUsername());

        //로그인 유효성 검사 후 메시지 리턴
        UserValidator.loginCheck(foundUsername, loginRequestDto, passwordEncoder);
        return new LoginResponseDto(jwtTokenProvider.createToken(loginRequestDto.getUsername()), true, "로그인 성공");

    }

    // 중복 체크
    public SignUpResponseDto duplicationCheck(DuplicationRequestDto duplicationRequestDto) {
        try {

            if (userRepository.existsByUsername(duplicationRequestDto.getUsername())) {
                throw new IllegalArgumentException("중복된 아이디가 존재합니다.");
            }
            if (userRepository.existsByNickname(duplicationRequestDto.getNickname())) {
                throw new IllegalArgumentException("중복된 닉네임이 존재합니다.");
            }
            if (userRepository.existsByEmail(duplicationRequestDto.getEmail())) {
                throw new IllegalArgumentException("중복된 이메일이 존재합니다.");
            }

        } catch (IllegalArgumentException e) {
            throw e;
        }
        return new SignUpResponseDto(true, "중복확인 완료");
        }
}

