package com.example.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// private라서?
@Getter@Setter@AllArgsConstructor
@Entity(name = "user")
// 어떤 테이블과 매핑할것인가
@Table(name = "user")
public class UserEntity {

    // 기본키 설정
    @Id
    private String email;

    private String password;
    private String nickname;
    private String telNumber;
    private String address;
    private String addtessDetail;
    private String profileImageUrl;
    
}
