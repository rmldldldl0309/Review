package com.kimsangheon.basic.repositiry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
// - 매개타입 ID : 해당 Repository에서 사용하는 Entity의 Primary key 데이터 타입을 지정한는 매개타입
public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{
    // student 테이블에서 address 가 '서울특별시'인 레코드를 조회
    // SQL :
    // select * from student 
    // where address = '서울특별시';
    List<StudentEntity> findByAddress(String address);

    // SQL :
    // SELECT * FROM student 
    // WHERE graduation IS true 
    // ORDER BY age DESC
    // > 경우의 수 0 ~ n개 = List로 반환
    List<StudentEntity> findByGraduationOrderByAgeDesc(Boolean graduation);

    // SQL :
    // SELECT * FROM  student
    // WHERE student_number = 5
    //      AND age > 20;
    // > 경우의 수 0 ~ 1개 = StudentEntitiy로 반환
    StudentEntity findByStudentNumberAndAgeGreaterThan(Integer studentNumber, Integer age);

    // SQL :
    // SELECT count(*) FROM student
    // WHERE graduation IS false;
    int countByGraduation(Boolean gradiation);

    // address가 서울특별시면서 graduation이 true인 레코드가 존재하는가?
    boolean existsByAddressAndGraduation(String address, Boolean graduation);

    // @Query : 
    // - 쿼리 메서드 생성방식만으로는 실제 SQL을 작성하는데 한계가 있다
    // - 쿼리 메서드 생성방식으로는 복잡한 쿼리, 조인, 서브쿼리, 그룹함수를 사용할 수 없다
    // - 직접 SQL문으로 쿼리를 생성하도록하는 어노테이션

    // ex) 
    // SELECT * FROM student
    // WHERE student_number = 5
    // AND age > 20

    // JPQL (Java Persistence Query Language)
    // - 표준 SQL과 매우 흡사, Entity명과 Entity속성으로 쿼리를 작성하는 방법
    @Query(
        value = 
        // FROM Entitiy명 > @Entity로 지정해 준 이름으로
        // SELECT * = SELECT s  => 이름을 가져온다면 SELECT s.name
        "SELECT s FROM student s WHERE s.studentNumber = ?1 AND s.age > ?2",
        nativeQuery=false
    )
    List<StudentEntity> getStudent2(Integer studentNumber, Integer age);
    
    // Native SQL
    // - 현재 사용하고 있는 RDBMS의 SQL문법을 그대로 따르는 방식
    @Query(
        // > ?1 : 첫번째 매개변수 값을 넣겠다 / ?2 : 두번째 매개변수 값을 넣겠다
        // SELECT * 로 하면 student_number와 Entity의 studentNumber가 달라서 alias를 통해 해결
        value = "SELECT " + 
                        "student_number AS studentNumber, " +
                        "name, age, address, graduation " + 
                    "FROM " + 
                        "student " + 
                    "WHERE " + 
                        "student_number = ?1 AND age > ?2",
        nativeQuery = true
    )
    List<StudentEntity> getStudent(Integer studentNumber, Integer age);

    @Query(
        value = "SELECT " + 
                        "student_number AS studentNumber, " +
                        "name, age, address, graduation " + 
                    "FROM " + 
                        "student " + 
                    "WHERE " + 
                        "student_number = :student_number AND age > :age ",
        nativeQuery = true
    )
    List<StudentEntity> getStudent3(
        // @Param 을 통해 : 뒤의 값과 매핑
        @Param("student_number") Integer studentNumber, 
        @Param("age") Integer age
        );

    StudentEntity findByStudentNumber(Integer studentNumber);

}   
