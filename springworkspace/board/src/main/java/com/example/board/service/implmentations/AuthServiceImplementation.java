package com.example.board.service.implmentations;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.board.dto.request.auth.SignUpRequestDto;
import com.example.board.dto.response.ResponseDto;
import com.example.board.entity.UserEntity;
import com.example.board.repository.UserRepository;
import com.example.board.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImplementation implements AuthService{

    private final UserRepository userRepository;

    @Override
    public ResponseEntity<ResponseDto> signUp(SignUpRequestDto dto) {
        try {
            // 1. 입력받은 이메일이 테이블에 존재하는지 조회
            String email = dto.getEmail();
            Boolean isExistEmail = userRepository.existsByEmail(email);

            // 1-1. 1에 대한 조회결과가 true : 중복된 이메일 응답 처리
            if (isExistEmail) return ResponseDto.duplicateEmail();

            // 2. 입력받은 닉네임이 테이블에 존재하는지 조회
            String nickname = dto.getNickname();
            Boolean isExistNickname = userRepository.existsByNickname(nickname);

            // 2-1. 2에 대한 조회결과가 true : 중복된 이메일 응답 처리
            if (isExistNickname) return ResponseDto.duplicateNickname();

            // 3. 입력받은 휴대전화번호가 테이블에 존재하는지 조회
            String telNumber = dto.getTelNumber();
            Boolean isExistTelNumber = userRepository.existsByTelNumber(telNumber);

            // 3-1. 3에 대한 조회결과가 true : 중복된 이메일 응답 처리
            if (isExistTelNumber) return ResponseDto.duplicateTelNumber();

            // 4. User 데이터 레코드 삽입
            // 4-1. User 엔티티의 인스턴스 생성 : (dto) -> userEntity 인스턴스
            UserEntity userEntity = new UserEntity(dto);

            // 4-2. User 엔티티의 인스턴스 저장
            userRepository.save(userEntity);
            // 5. 성공 응답 처리
            return ResponseDto.success(); 
            // 데이터 자체가 필요한 것이 아니라 존재하는지만 알면 됨 exist 사용

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }
        // 1. User테이블에서 데이터를 받아와 같은지 아닌지 비교 (email, nickname, telNumber)
        // 2. 조회 결과에 따른 응답처리 
        //      2-1 : 중복된 이메일
        //      2-2 : 중복된 닉네임
        //      2-3 : 중복된 전화번호
        // 3. 성공시 데이터를 User 테이블에 저장 + success

}       
