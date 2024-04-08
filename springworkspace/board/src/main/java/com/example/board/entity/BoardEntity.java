package com.example.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "board")
@Table(name = "board")
@NoArgsConstructor
public class BoardEntity {
    
    @Id
    // auto_increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer boardNumber;

    private String title;
    private String contents;
    private Integer viewCount;
    private Integer commentCount;
    private Integer favoriteCount;
    private String writeDatetime;
    private String writerEmail;
    
}
