package com.kimsangheon.basic.provider;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.kimsangheon.basic.entity.CustomOath2User;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
// OAuth2에 대한 모든 처리 과정이 성공적으로 끝났을 때 수행하는 메서드를 생성하기 위한 클래스
// - 반드시 SimpleUrlAuthenticationSuccessHandler 클래스 확장해야함
public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler{

    private final JwtProvider jwtProvider;

    @Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
        
        // OAuth2UserServiceImplement에서 반환하는 OAuth2User 객체를 받아옴
        CustomOath2User customOath2User = (CustomOath2User) authentication.getPrincipal();

        // OAuth2User 객체의 사용자 이름 가져옴
        String name = customOath2User.getName();
        // jwt 발급
        String token = jwtProvider.create(name);

        response.getWriter().write(token);
        
    }
}
