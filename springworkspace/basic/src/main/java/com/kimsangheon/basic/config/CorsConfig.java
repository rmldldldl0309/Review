package com.kimsangheon.basic.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// @configuration : Stprin boot 기본설정 지정 및 변경
@Configuration
// Cors 관련 설정을 변경하기 위해 WebMvcConfigurer 인터페이스에 존재하는 addCorsMapping 메서드를 오버라이드 하여 재정의
public class CorsConfig implements WebMvcConfigurer{
    
    @Override
    public void addCorsMappings (CorsRegistry registry){
        registry
        // 어떤 Request URL 패턴에 대하여 Cors 정책을 지정할 것이냐 > 모든 패턴 **
        .addMapping("/**")
        // 해당 Request URL 패턴의 어떤 메서드에 Cors 정책을 허용할 것인가  > 모든 메서드
        .allowedMethods("*")
        // 해당 Request URL 패턴에 어떤 출처의 Cors 정책을 허용할 것인가 > 모든 오리진
        .allowedOrigins("*");
    }
}
