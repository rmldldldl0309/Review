package com.example.board.dto.Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseDto {
    private String code;
    private String message;

    public static ResponseEntity<ResponseDto> databaseError () {
        ResponseDto body = new ResponseDto(ResponseCode.DATABASE_ERROR, ResponseMessage.DATABASE_ERROR);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }

    public static ResponseEntity<ResponseDto> notExistUser () {
        ResponseDto body = new ResponseDto(ResponseCode.THIS_USER_DOES_NOT_EXIST, ResponseMessage.THIS_USER_DOES_NOT_EXIST);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(body);
    }
    
}
