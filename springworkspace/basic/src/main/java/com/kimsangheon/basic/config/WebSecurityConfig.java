package com.kimsangheon.basic.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.web.SecurityFilterChain;

// 등록
@Configuration

// 수정
// @Configurable :
// - 생성자나 `메서드`가 호출될 때 Spring Bean 등록을 자동화(제어 역전)하는 어노테이션
@Configurable
// @EnableWebSecurity :
// - Web Security 설정을 지원하도록 하는 어노테이션
@EnableWebSecurity
public class WebSecurityConfig {

    // @Bean : 
    // - Spring bean으로 등록하는 어노테이션
    // - @Component를 사용하지 못할 때 사용 / 이번의 경우 인스턴스를 생성하는 것이 아닌 메서드이기 때문
    // - @Autowired의 목적이 아닐 때 사용
    @Bean
    protected SecurityFilterChain configure(HttpSecurity security) throws 
    Exception{
        // class::method :
        // - 메서드 참조, 특정 클래스에 메서드를 참조할 때 사용, 일반적으로 매개변수로 메서드를 전달할 때 사용됨
        security
        // basic authentication 미사용 지정
        .httpBasic(HttpBasicConfigurer::disable);
        return security.build();
    }

}
