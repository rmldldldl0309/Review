package com.kimsangheon.basic.service;

import org.springframework.http.ResponseEntity;

import com.kimsangheon.basic.dto.request.student.PatchStudentRequestDto;
import com.kimsangheon.basic.dto.request.student.PostStudentRequestDto;


public interface StudentService {
    // RequestBody 사용하니 Dto사용
    ResponseEntity<String> postStudent(PostStudentRequestDto dto);
    ResponseEntity<String> patchStudent(PatchStudentRequestDto dto);

    ResponseEntity<String> deleteStudent(Integer studentNumber);
}
