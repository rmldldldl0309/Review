package com.example.board.service;

import org.springframework.http.ResponseEntity;

import com.example.board.dto.Response.board.GetLatestListResponseDto;

public interface BoardService {
        ResponseEntity<? super GetLatestListResponseDto> getLatestList ();
}
