use practice_sql;
 
create table employees (
	employee_number int auto_increment primary key,
    name varchar(30),
    department_code varchar(5)
 );
 
 create table department (
	code varchar(5) primary key,
    name varchar(10) not null,
    tel_number varchar(15) not null
 );
 
 alter table employees 
 add constraint foreign key (department_code) references department (code);
 
 insert into department values ('HR', '인사부', '051-111-1111');
 insert into department values ('FI', '재무부', '051-222-2222');
 insert into department values ('DV', '개발부', '051-333-3333');
 
 insert into employees (name, department_code) values ('홍길동', null);
 insert into employees (name, department_code) values ('김서준', null);
 insert into employees (name, department_code) values ('이민준', 'HR');
 insert into employees (name, department_code) values ('최시우', 'HR');
 insert into employees (name, department_code) values ('강지호', 'FI');
 insert into employees (name, department_code) values ('박도현', 'FI');
 
-- # JOIN: 두 개 이상의 테이블의 특정 조건에 따라 조합하여 결과를 조회하고자 할때 사용하는 명령어

-- 1. INNER JOIN
# : 두 테이블에서 조건이 일치하는 레코드만 반환
select 
	e.employee_number employee_number, e.name employee_name,
    d.code as department_code,
    d.tel_number as department_tel_number
from employees e inner join department d
on e.department_code = d.code;

-- 2. LEFT OUTER JOIN (LEFT JOIN)
# : 첫 번째 테이블의 모든 레코드와 두 번째 테이블의 조건이 일치하는 레코드를 반환,
# : 첫 번째 테이블의 레코드에서 조건이 일치하는 값이 없으면 null로 표현
select 
	e.employee_number employee_number, e.name employee_name,
    d.code as department_code,
    d.tel_number as department_tel_number
from employees e left outer join department d
on e.department_code = d.code;

-- 3. RIGHT OUTER JOIN (RIGHT JOIN)
# : 두 번째 테이블의 모든 레코드와 첫 번째 테이블의 조건이 일치하는 레코드를 반환,
# : 두 번째 테이블의 레코드에서 조건이 일치하는 값이 없으면 null로 표현
select 
	e.employee_number employee_number, e.name employee_name,
    d.code as department_code,
    d.tel_number as department_tel_number
from employees e right outer join department d
on e.department_code = d.code;

select * from department where tel_number = '010-1111-1111';

