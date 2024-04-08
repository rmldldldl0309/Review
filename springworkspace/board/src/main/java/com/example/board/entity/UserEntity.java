package com.example.board.entity;

import com.example.board.dto.request.auth.SignUpRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// private라서?
@Getter@Setter@AllArgsConstructor@NoArgsConstructor
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
    private String addressDetail;
    private String profileImageUrl;
    
    public UserEntity (SignUpRequestDto dto){
        this.email = dto.getEmail();
        this.password = dto.getPassword();
        this.nickname = dto.getNickname();
        this.telNumber = dto.getTelNumber();
        this.address = dto.getAddress();
        this.addressDetail = dto.getAddressDetail();
    }
}
