package com.example.board.dto.Response.board.item;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardListItem {
    private Integer boardNumber;
    private String title;
    private String content;
    private String boardTitleImage;
    private Integer favoriteCount; 
    private Integer commentCount;
    private Integer viewCount;
    private String writeDatetime;
    private String writerNickname;
    private String writerProfileImage;

}
