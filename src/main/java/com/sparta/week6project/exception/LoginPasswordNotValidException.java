package com.sparta.week6project.exception;

public class LoginPasswordNotValidException extends RuntimeException{
    private static final String MESSAGE = "비밀번호를 다시 확인해 주세요.";

    public LoginPasswordNotValidException () {
        super(MESSAGE);
    }

}
