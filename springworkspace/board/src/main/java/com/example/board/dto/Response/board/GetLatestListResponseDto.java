package com.example.board.dto.Response.board;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.board.dto.Response.ResponseCode;
import com.example.board.dto.Response.ResponseDto;
import com.example.board.dto.Response.ResponseMessage;
import com.example.board.dto.Response.board.item.BoardListItem;

import lombok.Getter;

@Getter
public class GetLatestListResponseDto extends ResponseDto {
    
    private List<BoardListItem> latestList;

    // public -> private로 변경 > 클래스 내부에서만 사용 가능
    private GetLatestListResponseDto(List<BoardListItem> latestList) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.latestList = latestList;
    }

    // 클래스 자체로 접근할 수 있도록
    public static ResponseEntity<GetLatestListResponseDto> success (List<BoardListItem> latestList) {
        GetLatestListResponseDto body = new GetLatestListResponseDto(latestList);
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

}
