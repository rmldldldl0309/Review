package com.kimsangheon.basic.controller;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kimsangheon.basic.service.BasicService;


import lombok.RequiredArgsConstructor;

// Controller 레이어
// - 클라이언트와 서버간의 접점
// - 클라이언트의 요청을 받고 해당 요청에 대한 응답을 클라이언트에게 돌려주는 영역
// - 각 요청에 해당하는 URL메서드를 작성하는 영역

// @RestController : JSON 형태의 Response Body를 반환하는 Controller 임을 명시
// = @Controller + @ResponseBody
@RestController

// @RequestMapping() : HTTP요청에 클래스와 메서드를 매핑하기 위한 어노테이션
// @RequestMapping(value = "/main", method = {RequestMethod.GET})
// > HTTP GET localhost:4000/main/**
@RequestMapping("/main")

// 서비스가 많은 경우 생성자가 너무 많아짐 > Lo mbok의 @AllArgsConstrutor 활용
// @AllArgsConstructor

// final로 선언되어있는 필드 변수에 대해 생성자를 자동으로 작성
@RequiredArgsConstructor
public class BasicController {

    //! 생성자로 의존성 주입
    // private BasicService service;

    // 의존성 역전 (DI) : 
    // - 해당 클래스에 필요한 의존성을 외부(클래스의 인스턴스를 생성하는 위치)에서  주입
    // - 생성자를 통한 의존성 주입 / setter 메서드를 통한 의존성 주입 / 필드를 통한 의존성 주입
    // > spring에서는 생성자를 통한 의존성 주입을 권장하고 있다
    // > 의존성이 주입되지 않은 경우는 존재할 수 없기 때문에 (생성자는 무조건 실행)
    // - spring framework 에서 의존성 주입은 제어의 역전 (IoC)을 통해 spring framework가 진행 (@Component 를 사용하여 Spring Bean을 등록된 클래스에 한함)

    // @Autowired : 등록된 Spring Bean을 제어의 역전을 통해 의존성을 주입하는 방법
    // - 단, 생성자를 통한 의존성을 주입하는 경우 @Autowired는 생략될 수 있다
    
    // @Autowired
    // public BasicController (BasicService service){
    //     this.service = service;
    // }
    // 
    
    //! 의존성 주입 시 클래스로 직접 참조변수를 만들지 않고 인터페이스로 간접적으로 만드는 이유 :
    // 고수준 (사용한다 = 수준 높다)의 모듈에서 저수준의 모듈을 직접 참고하지 않고 추상화를 통해 간접 참조함으로써 각 모듈간의 결합도를 낮춤
    // > 코드의 재사용성 향상과 유지보수성 향상을 불러올 수 있다
    // final 변경 X  >  setter메서드 X  >  무조건 초기화 일어나야하기에 X
    private final BasicService service;

    //!
    
    // HTTP GET localhost:4000/main/
    @RequestMapping(value = "/", method = {RequestMethod.GET})
    public String getHello(){
        return "Hello Springboot";
    }

    //! HTTP GET Method : 클라이언트가 서버로부터 데이터를 받기를 원할 때 사용하는 메서드
    // @GetMapping() : RequestMapping 기능을 GET Method에 한정시킨 것 (가독성 + 안정성)
    @GetMapping("/apple")
    public String getApple(){
        return "Get Mapping으로 만든 메서드";
    }

    //! HTTP POST Method : 클라이언트가 서버에 데이터를 작성하기를 원할 때 사용하는 메서드
    // @PostMapping() : RequestMapping 기능을 POST Method에 한정시킨 것 (가독성 + 안정성)
    @PostMapping("/apple")
    public String postApple(){
        return "Post Mapping으로 만든 메서드"; 
    }

    //! HTTP PUT Method : 클라이언트가 서버에 있는 리소스 전체를 수정하고자 할 때 사용하는 메서드
    // @PutMapping() : RequestMapping 기능을 PUT Method에 한정시킨 것 (가독성 + 안정성)
    @PutMapping("/apple")
    public String putApple(){
        return "PUT Mapping으로 만든 메서드";
    }
    
    //! HTTP PATCH Method : 클라이언트가 서버에 있는 리소스 일부를 수정하고자 할 때 사용하는 메서드
    // @PatchMapping() : RequestMapping 기능을 PATCH Method에 한정시킨 것 (가독성 + 안정성)
    @PatchMapping("/apple")
    public String patchApple(){
        return "Put Mapping으로 만든 메서드";
    }

    //! HTTP DELETE Method : 클라이언트가 서버에 있는 리소스를 삭제하고자 할 때 사용하는 메서드
    // @DeleteMapping() : RequestMapping 기능을 DELETE Method에 한정시킨 것 (가독성 + 안정성)
    @DeleteMapping("/apple")
    public String deleteApple(){
        return "Delete Mapping으로 만든 메서드";
    }

    // Method + URL Pattern이 중복되면 런타임 중에 에러 발생
    // @DeleteMapping("/apple")
    // public String deleteApple2(){
    //     return "Delete Mapping으로 만든 메서드";
    // }

    // https://developer.mozilla.org/ko/docs/Web/HTTP/Methods 
}
