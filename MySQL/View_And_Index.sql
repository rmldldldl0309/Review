use practice_sql;

-- # VIEW: 논리적으로만 존재하는 읽기 전용의 가상의 테이블
# : 제한된 보기를 제공할 때, 특정 쿼리문(SELECT)을 미리 작성해두는 용도
create view employee_view 
as
select 
	e.employee_number employee_number, e.name employee_name,
    d.code as department_code,
    d.tel_number as department_tel_number
from employees e left outer join department d
on e.department_code = d.code;

select * from employee_view;
select * from employee_view where employee_name = '홍길동';

# VIEW 는 물리적으로 데이터가 복사되는 갓이 아닌, 논리적으로 결과를 불러오는 것.
# > INSERT< UPDATE< DELELTE 블기
insert into employee_view values(10, '김길동', 'MM', '물류부' );
drop view employee_view;

-- # 인덱스 (INDEX): 테이블에서 데이터를 빠르게 조회할 수 있도록 도와주는 요소
create index department_tel_number_index
on department (tel_number);

create index department_index_1
on department (name, tel_number);

select * from department where tel_number = '010-1111-1111';

# 아래보다 위가 속도 더 빠름 / index 선언 시 순서에 따름
select * from department where name = '인사부' and tel_number = '010-1111-1111';     
select * from department where tel_number = '010-1111-1111' and name = '인사부' ;     

drop index department_index_1 on department;
