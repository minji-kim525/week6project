package com.sparta.week6project.exception;


import com.sparta.week6project.dto.responseDto.SignUpResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
// Controller에서 Exception이 발생했을 때 Json형태로 body부분을 넘겨준다.
// 이렇게 처리를 안하고 평소대로 던지기만하면 다 500에러로 출력되니까
@RestControllerAdvice
public class RestApiExceptionHandler {

    @ExceptionHandler(value = { IllegalArgumentException.class})
    public ResponseEntity<Object> temp1 (IllegalArgumentException e) {
        SignUpResponseDto ResponseException = new SignUpResponseDto();
        ResponseException.setOk(false);
        ResponseException.setMessage(e.getMessage());

        return ResponseEntity.badRequest().body(ResponseException);
    }

    @ExceptionHandler(value = { NullPointerException.class})
    public ResponseEntity<Object> temp2 (NullPointerException e) {
        SignUpResponseDto ResponseException = new SignUpResponseDto();
        ResponseException.setOk(false);
        ResponseException.setMessage(e.getMessage());

        return ResponseEntity.badRequest().body(ResponseException);
    }
}
