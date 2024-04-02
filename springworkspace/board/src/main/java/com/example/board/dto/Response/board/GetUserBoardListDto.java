package com.example.board.dto.response.board;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.board.dto.response.ResponseDto;
import com.example.board.dto.response.ResponseCode;
import com.example.board.dto.response.ResponseMessage;
import com.example.board.dto.response.board.item.BoardListItem;

import lombok.Getter;


@Getter
public class GetUserBoardListDto extends ResponseDto{

    private List<BoardListItem> userList;

    private  GetUserBoardListDto(List<BoardListItem> userList) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.userList = userList;
    }

    private static ResponseEntity<GetUserBoardListDto> success (List<BoardListItem> userList) {
        GetUserBoardListDto body = new GetUserBoardListDto(userList);
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }
    
}
