package com.example.board.service;

import org.springframework.http.ResponseEntity;

import com.example.board.dto.response.user.GetUserDto;

public interface UserService {
    ResponseEntity<? super GetUserDto> getUser ();
}
