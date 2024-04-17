package com.kimsangheon.basic.service;

public interface BasicService {
    // 인터페이스의 메서드는 반드시 public abstract 이어야 함
    // public abstract String getHello();

    // public abstract 생략 가능
    String getHello();
    String getApple();

    String getJwt(String principle);

    String jwtValidate(String jwt);
    
}