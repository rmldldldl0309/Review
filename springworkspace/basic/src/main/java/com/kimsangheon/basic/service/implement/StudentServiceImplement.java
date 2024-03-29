package com.kimsangheon.basic.service.implement;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kimsangheon.basic.dto.request.student.PatchStudentRequestDto;
import com.kimsangheon.basic.dto.request.student.PostStudentRequestDto;
import com.kimsangheon.basic.entity.StudentEntity;
import com.kimsangheon.basic.repositiry.StudentRepository;
import com.kimsangheon.basic.service.StudentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImplement  implements StudentService{

    private final StudentRepository studentRepository;
    @Override
    public ResponseEntity<String> postStudent(PostStudentRequestDto dto) {
        
        // CREATE (SQL : INSERT)
        // 1. Entity 클래스의 인스턴스 생성
        // 2. 생성한 인스턴스를 repository.save(메서드로 저장)
        StudentEntity studentEntity = new StudentEntity(dto);
        // save() : 저장 및 수정 (덮어쓰기) > 조심
        studentRepository.save(studentEntity);

        return ResponseEntity.status(HttpStatus.CREATED).body("성공!");
    }

    //                                                                      SQL
    // 1. update student                                                   student테이블로 접근
    // 2. set address = dto.addreess                                 dto.studentNumbre에 해당하는 레코드 검색
    // 3. where student_number = dto.student_number   검색된 레코드의 address값을 dto.address로 변경

    // 객체 지향프로그래밍언어의  클래스 == RDBMS의 테이블
    // 객체 지향프로그래밍언어의  인스턴스 == RDBMS의 레코드

    //                          객체지향언어
    // 1. student클래스로 접근
    // 2. dto.studentNumbre에 해당하는 인스턴스 검색
    // 3. 검색된 인스턴스의 address값을 dto.address로 변경

    @Override
    public ResponseEntity<String> patchStudent(PatchStudentRequestDto dto) {
        Integer studentNumber = dto.getStudentNumber();
        String address = dto.getAddress();

        // 0. student 테이블에 해당하는 Primary key를 가지는 레코드가 존재하는지 확인
        boolean isExistedStudent = studentRepository.existsById(studentNumber);
        if (!isExistedStudent) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("존재하지 않는 학생입니다");

        // 1. student클래스로 접근
        StudentEntity studentEntity = studentRepository.
        // 2. dto.studentNumbre에 해당하는 인스턴스 검색
        findById(studentNumber).get();
        // 3. 검색된 인스턴스의 address값을 dto.address로 변경
        studentEntity.setAddress(address);
        // 4. 변경한 인스턴스를 데이터베이스에 저장
        // respository.save()는 레코드를 생성할 때 쓰이지만, 수정시에도 사용된다
        studentRepository.save(studentEntity);

        return ResponseEntity.status(HttpStatus.OK).body("성공");
    }

    @Override
    public ResponseEntity<String> deleteStudent(Integer studentNumber) {

        studentRepository.deleteById(studentNumber);

        return ResponseEntity.status(HttpStatus.OK).body("성공");
    }


    
}

// table  > class 와 매핑 / instance생성 > recoed생성

// CRUD 
    // CREATE : 1~2 
    // READ : 엄청맘ㄶ음
    // UPDATE : 1~컬럼개수
    // DELETE : 1~2