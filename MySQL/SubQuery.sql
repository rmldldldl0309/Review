use practice_sql;

-- # 서브쿼리: 쿼리 내부에 위치하는 또 다른 쿼리, 쿼리 켤과를 조건이나 테이블로 사용할 수 있도록 함

-- 1. where 절에서 > 쿼리 결과를 조건으로 사용하여 조건을 동적으로 지정
# : where 절에서 비교 연산으로 사용될 때 조회하는 컬럼의 개수 및 레코드 개수 주의
select *
from employees
where department_code = (
	select code
    from department
    where name = '인사부'
);

-- 2. FROM 절에서 > 쿼리 결과 테이블을 다시 FROM 절에 사용하여 복합적인 테이블 조회
select *
from (
	select name employee_name, department_code
    from employees
    where department_code is null
) AS SQ
where employee_name = '홍길동';

# 부서 이름이 '개발부'인 사원이름, 부서코드, 부서명을 조회

# 부서 이름이 '개발부'인 사원이름, 부서코드를 조회
select name, department_code
from employees
where department_code = (select code 
	from department
	where name = '개발부'

);

-- 3. from 절에서 > 

