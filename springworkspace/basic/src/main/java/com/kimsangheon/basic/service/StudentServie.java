package com.kimsangheon.basic.service;

import org.springframework.http.ResponseEntity;

import com.kimsangheon.basic.dto.request.student.PostStudentRequestDto;

public interface StudentServie {
    ResponseEntity<String> postStudent(PostStudentRequestDto dto);
}
