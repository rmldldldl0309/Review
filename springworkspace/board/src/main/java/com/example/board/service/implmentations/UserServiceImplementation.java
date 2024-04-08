package com.example.board.service.implmentations;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.board.dto.request.user.UpdateNicknameRequestDto;
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
    
        // 유저 조회
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

    // 유저 닉네임 변경
    // 잘못된 API > 인증, 인가 작업 필요
    @Override
    public ResponseEntity<ResponseDto> patchNickname(UpdateNicknameRequestDto dto) {
        try{

            String nickname = dto.getNickname();
            Boolean isExistNickname = userRepository.existsByNickname(nickname);
            if (isExistNickname) return ResponseDto.duplicateNickname();

            String email = dto.getEmail();
            UserEntity userEntity = userRepository.findByEmail(email);
            if (userEntity == null) return ResponseDto.notExistUser();

            userEntity.setNickname(nickname);
            userRepository.save(userEntity);

            return ResponseDto.success();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        
    }

}
