package com.example.board.controller;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.dto.Request.PostAuthRequestDto;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    
    // 로그인 하기
    @PostMapping("/sign-in")
    public ResponseEntity<String> PostAuth (
        @RequestBody@Valid PostAuthRequestDto requestbody
    ){
        
        return null;
    }



}
