package com.example.board.service.implmentations;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.board.dto.response.ResponseDto;
import com.example.board.dto.response.user.GetUserResponseDto;
import com.example.board.entity.UserEntity;
import com.example.board.repository.UserRepository;
import com.example.board.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService{
    
    private final UserRepository userRepository;
    
    @Override
    public ResponseEntity<? super GetUserResponseDto> getUser(String email) {
    

        try {
            // 1. User테이블에서 email에 해당하는 유저 조회
            // select * from user where email = :email
            // 0~1개의 데이터 받아오므로 list사용할 필요 x
            // findByEmail(email)
            // (emil -> (true, false) / (조회 결과 인스턴스)
            UserEntity userEntity = userRepository.findByEmail(email);

            // 2-1 조회 결괴에 따라 반환 결정
            // 1) false이면 존재하지 않는 유저 응답처리
            // 2) null이면 존재하지 않는 유저 응답처리
            if (userEntity == null) return ResponseDto.notExistUser();

            // 3. 조회 결과 데이터 를 성공 응답으로
            return GetUserResponseDto.success(userEntity);

        } catch (Exception exception) {
            // 1-1 조회 처리 중 데이터베이스 관련 예외가 발생하면 데이터베이스 에러 응답처리
            exception.printStackTrace();
            return ResponseDto.databaseError();
        } 

    }

}
