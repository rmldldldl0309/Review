package com.example.board.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.dto.response.user.GetUserDto;
import com.example.board.service.UserService;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/{email}")
    public ResponseEntity<GetUserDto> GetUser (
        @PathVariable("email") String email
    ) {
        ResponseEntity<? super GetUserDto> response = userService.getUser(email);
        return response;
    }

}
