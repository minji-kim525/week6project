package com.sparta.week6project.exception;


import com.sparta.week6project.dto.responseDto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
// Controller에서 Exception이 발생했을 때 Json형태로 리턴해준다. <> @ResponseBody + @ConttrollerAdvice
// 이렇게 처리를 안하고 평소대로 던지기만하면 다 500에러로 출력되니까
@RestControllerAdvice
public class RestApiExceptionHandler {

    @ExceptionHandler(value = { IllegalArgumentException.class})
    public ResponseEntity<Object> temp1 (IllegalArgumentException e) {
        ErrorResponseDto ResponseException = new ErrorResponseDto(false, e.getMessage());
        return ResponseEntity.badRequest().body(ResponseException);
    }
//
//    @ExceptionHandler(LoginIdNotValidException.class)
//    public ResponseEntity<Object> handlerOrderPriceNotValidateException (LoginIdNotValidException e) {
//        return ResponseEntity.badRequest().body(e.getMessage());
//    }

    @ExceptionHandler(value = { NullPointerException.class})
    public ResponseEntity<Object> temp2 (NullPointerException e) {
        ErrorResponseDto ResponseException = new ErrorResponseDto();
        ResponseException.setOk(false);
        ResponseException.setMessage(e.getMessage());

        return ResponseEntity.badRequest().body(ResponseException);
    }
}
