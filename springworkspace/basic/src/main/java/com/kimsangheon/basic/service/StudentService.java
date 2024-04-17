package com.kimsangheon.basic.service;

import org.springframework.http.ResponseEntity;

import com.kimsangheon.basic.dto.request.student.PatchStudentRequestDto;
import com.kimsangheon.basic.dto.request.student.PostStudentRequestDto;
import com.kimsangheon.basic.dto.request.student.SignInRequestDto;


public interface StudentService {
    // RequestBody 사용하니 Dto사용
    ResponseEntity<String> postStudent(PostStudentRequestDto dto);
    ResponseEntity<String> patchStudent(PatchStudentRequestDto dto);
    ResponseEntity<String> deleteStudent(Integer studentNumber);
    ResponseEntity<String> signIn(SignInRequestDto dto);
}
