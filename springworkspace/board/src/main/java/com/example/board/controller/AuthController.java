package com.example.board.controller;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.dto.Request.PostSignInRequestDto;
import com.example.board.dto.response.ResponseDto;
import com.example.board.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    
    private final AuthService authService;

    // 로그인
    @PostMapping("/sign-in")
    public ResponseEntity<ResponseDto> PostSignIn (
        @RequestBody@Valid PostSignInRequestDto requestbody
    ){
        ResponseEntity<String> response = authService.PostSignIn(requestbody);
        return response;
    }

}
