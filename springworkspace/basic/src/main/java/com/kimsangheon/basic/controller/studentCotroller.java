package com.kimsangheon.basic.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kimsangheon.basic.dto.request.student.PatchStudentRequestDto;
import com.kimsangheon.basic.dto.request.student.PostStudentRequestDto;
import com.kimsangheon.basic.dto.request.student.SignInRequestDto;
import com.kimsangheon.basic.service.StudentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class studentCotroller {
    
    // 외부에서 주입
    private final StudentService studentService;

    // Create
    @PostMapping("/")
    public ResponseEntity<String> postStudent(
        // POST > Requesy Body에서 데이터 받아옴
        // @Valid 추가해야 유효성 검사 작동
        @RequestBody @Valid PostStudentRequestDto requestBody
    ) {
        ResponseEntity<String> response = studentService.postStudent(requestBody);
        return response;
    }

    // Update       
    @PatchMapping("/")
    public ResponseEntity<String> patchStudent(
        @RequestBody @Valid PatchStudentRequestDto requestBody
    ) {
        ResponseEntity<String> response = studentService.patchStudent(requestBody);
        return response;
    }

    // Delete
    @DeleteMapping("/{studentNumber}")
    public ResponseEntity<String> deleteStudent(
        // Path경로의 변수 사용 시
        @PathVariable("studentNumber") Integer studentNumber
    ) {
        ResponseEntity<String> response = studentService.deleteStudent(studentNumber);
        return response;
    }

    @PostMapping("/sign-in")
    public ResponseEntity<String> signIn(
        @RequestBody @Valid SignInRequestDto requestbody
    ){
        return studentService.signIn(requestbody);
    }

}
