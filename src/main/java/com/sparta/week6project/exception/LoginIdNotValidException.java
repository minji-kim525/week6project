package com.sparta.week6project.exception;

public class LoginIdNotValidException extends RuntimeException{
    private static final String MESSAGE = "존재하지 않는 아이디입니다.";

    public LoginIdNotValidException () {
        super(MESSAGE);
    }

}
