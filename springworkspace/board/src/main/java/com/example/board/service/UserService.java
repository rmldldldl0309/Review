package com.example.board.service;

import org.springframework.http.ResponseEntity;

import com.example.board.dto.Response.user.GetUserResponseDto;

public interface UserService {
    ResponseEntity<? super GetUserResponseDto> getUser (String email);
}
