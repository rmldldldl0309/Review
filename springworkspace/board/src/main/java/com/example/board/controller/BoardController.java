package com.example.board.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.dto.response.board.GetLatestListResponseDto;
import com.example.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/board")
// final에 대한 생성자
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    
    @GetMapping("/latest-list")
    // super를 통해 true일 시 GetLatestListResponseDto를 false일 시 ResponseDto
    public ResponseEntity<? super GetLatestListResponseDto> GetLatestList() {
        return null;
    }
}
