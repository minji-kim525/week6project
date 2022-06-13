package com.sparta.week6project.service;

import com.sparta.week6project.dto.requestDto.SignupRequestDto;
import com.sparta.week6project.model.User;
import com.sparta.week6project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public String registerUser(SignupRequestDto requestDto) {
            userRepository.save(new User(requestDto));
        return "성공";
    }
}