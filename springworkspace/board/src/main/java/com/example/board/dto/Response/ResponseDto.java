package com.example.board.dto.response;

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

    // ===============================================================================================================================
    public static ResponseEntity<ResponseDto> validaitonFailed () {
        ResponseDto body = new ResponseDto(ResponseCode.VALIDATION_FAILED, ResponseMessage.VALIDATION_FAILED);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
    public static ResponseEntity<ResponseDto> duplicateEmail () {
        ResponseDto body = new ResponseDto(ResponseCode.DUPLICATE_EMAIL, ResponseMessage.DUPLICATE_EMAIL);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
    public static ResponseEntity<ResponseDto> duplicateNickname () {
        ResponseDto body = new ResponseDto(ResponseCode.DUPLICATE_NICKNAME, ResponseMessage.DUPLICATE_NICKNAME);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
    public static ResponseEntity<ResponseDto> duplicateTelephoneNumber () {
        ResponseDto body = new ResponseDto(ResponseCode.DUPLICATE_TELEPHONE_NUMBER, ResponseMessage.DUPLICATE_TELEPHONE_NUMBER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

}
    

