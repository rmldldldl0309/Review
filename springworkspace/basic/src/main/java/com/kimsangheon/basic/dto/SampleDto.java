package com.kimsangheon.basic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// DTO 작성 시 이렇게 4가지 어노테이션 해주기
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@ToString
public class SampleDto {
    // 캡슐화를 위해 private
    private String userId;
    private String userPassword;

}
