package com.example.board.exceptionhandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.board.dto.response.ResponseDto;

// 컨트롤러에 대한 조언?
@RestControllerAdvice
public class ValidationExceptionHandler {
    
    @ExceptionHandler(
        value = {
            HttpRequestMethodNotSupportedException.class,
            MethodArgumentNotValidException.class
        })
    public ResponseEntity<ResponseDto> validationExceptionHandler() {
        return ResponseDto.validaitonFailed();
    }



}

