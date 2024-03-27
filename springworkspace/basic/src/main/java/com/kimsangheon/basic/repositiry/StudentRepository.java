package com.kimsangheon.basic.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kimsangheon.basic.entity.StudentEntity;

// Respositoty 레이어 : 
// - 데이터베이스와 관련된작업들을 처리하는 영역
// - Service가 비즈니스 로직 수행 중 데이터베이스 작업이 필요할때 Respository를 거쳐 데이터베이스 작업 수행

// @Repository
// 해당 클래스를 Spring Bean으로 등록, @Component와 동일
// - interface에 @Repository를 사용하는 이유
// - JPA를 사용하면 JpaRepository 인테페이를 상속받은 인터페이스의 구현체를 JPA가 자동으로 생성
@Repository
// JpaRepository <T, ID> : 
// - JPA 기반의 Repository를 구현하는 주요 인터페이스
// - 기본 CRUD, 정렬 기능을 제공하고 있음
// - Jpa 기반 Repository를 생성할 때 반드시 상속해야한다
// - 매개타입 T : 해당 Repository가 어떤 Entity의 Repository인지 나타내는 매개타입
// - 매개타입 ID : 해당 Repository에서 사용하는 Entity의 Primary key 데이터 타입을 지정한느 매개타입
public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{
    
}
