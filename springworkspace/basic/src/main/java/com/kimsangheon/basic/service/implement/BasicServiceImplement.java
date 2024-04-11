package com.kimsangheon.basic.service.implement;

import org.springframework.stereotype.Service;

import com.kimsangheon.basic.provider.JwtProvider;
import com.kimsangheon.basic.service.BasicService;

import lombok.RequiredArgsConstructor;

// Service 레이어 : 
// - 실제 비즈니스 로직(연산)을 실행하는 영역
// - 트랜잭션 처리나 유효성 검사(직전 비즈니스 로직에 대한)를 수행하기도 함
// - controller로 부터 받은 요청 데이터에 대해서 필요에 따라 Repository등을 거쳐 연산을 수행하고 Controller에 응답에 대한 데이터를 반환

// @Service : 해당 클래스를 Spring Bean 으로 등록하는 어노테이션
// @Component : 해당 클래스를 Spring Bean으로 등록하는 어노테이션
// > 둘의 역할 차이 X
// Spring Bean : 제어의 역전을 통해 의존성 주입 시 해당 클래스의 인스턴스를 Spring Framework 가 제어하게 만드는 요소
@Service
@RequiredArgsConstructor
public class BasicServiceImplement implements BasicService{

    private final JwtProvider jwtProvider;

    @Override
    public String getHello() {
        return "Hello Springboot";
    }

    @Override
    public String getApple() {
        return "Get Mapping으로 만든 메서드";
    }

    @Override
    public String getJwt(String principle) {
        return jwtProvider.create(principle);
    }

}