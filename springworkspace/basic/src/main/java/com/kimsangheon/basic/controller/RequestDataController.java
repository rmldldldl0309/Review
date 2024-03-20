package com.kimsangheon.basic.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kimsangheon.basic.dto.SampleDto;

@RestController
// HTTP * localhost:4000/request-data/**
@RequestMapping("/request-data")
public class RequestDataController {
    
    //? @RequestParam() : GET, DELETE 처럼 URL로 데이터를 전송하는 메서드에서 Query String 으로 지정된 데이터를 가져오기 위해 사용
    // HTTP localhost:4000/request-data/request-param
    @GetMapping("/request-param")
    //  http://localhost:4000/request-data/request-param?userId=qwer&userName=gildong&userAge=10  >  ? 이후 부분이 Query String
    public String getRequestParam (
        @RequestParam(name = "userId") String userId,                     // `? 뒤의 userId를 찾아 데이터(qwer)를 String userId에 저장
        @RequestParam(name = "userName", required = false) String userName,
        @RequestParam int userAge
    ) {
        return "사용자 아이디 : " + userId + " / 사용자 이름 : " + userName + " / 사용자 나이 : " + userAge ;
    }

    //? @PathVariable() : 모든 HTTP 메서드에서 URL의 특정 패턴에 따라 데이터를 추출하는 방식 
    // HTTP DELETE localhost:4000/request-data/path-variable
    @DeleteMapping({
        "/path-variable/{age}/{name}",
        "/path-variable/{age}"
    })
    //  http://localhost:4000/request-data/path-variable/{age}/{name}
    public String deletePathVariable (
        @PathVariable("age") Integer age     ,
        @PathVariable(name = "name", required=false) String name                                // int 보다 Integer > 데이터 입력 안했을 때 null값이 나오는게 유리  
    ) {
        return "사용자 나이 : " + age + " / 사용자 이름 : " + name;
    }

    // HTTP PATCH localhost:4000/request-data/patch
    @PatchMapping("/patch/{userName}/update")
    //  http://localhost:4000/request-data/patch/{userName}/update
    public String patchUpdate (
        @PathVariable("userName") String userName
    ) {
        return "사용자 이름  : " + userName;
    }

    //! ***** 주의
    //! URL 패턴으로 데이터를 받아오는 방식을 썻을 때 중복되는 패턴이 존재하는지 잘 확인해야 한다
    @ GetMapping("/{value}/get")
    public String getPathVariable1 (
        @PathVariable("value") String value
    ) {
        return "getPathVariable1"; 
    }

    @ GetMapping("/get/{value}")
    public String getPathVariable2 (
        @PathVariable("value") String value
    ) {
        return "getPathVariable2"; 
    }

    //? @RequestBody() : POST, PATCH, PUT 처럼 RequestBody로 데이터를 전송하는 메서드에서 데이터를 가져오기 위해 사용
    // HTTP PATCH localhost:4000/request-data/post
    @PostMapping("/post")
    public String post (
        // @RequestBody String text
        @RequestBody SampleDto dto
    ) {
        return "전송한 데이터 : " + dto.toString();
    }

}