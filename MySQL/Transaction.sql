use practice_sql;

-- transaction: sql로 작업하는 작업 단위

-- 특성
# 1. atomicity(원자성)ㅣ트랜잭션은 모두 성공하거나 모두 성공하여야 
# 2. consistancy(일관성)ㅣ트랜잭션의 작업 결과는 항상 일관성이 있어야 한다
# 3. isolation(독립성)ㅣ트랜잭션은 모두 독립적이어야 한다
# 4. durability(영구성)ㅣ트랜잭션이 성공적으로 완료되면 영구히 반영되어야 한다

-- 회원가입: user, email_authentication
# 사용자는 아이디를 입력하고 중복 확인을 함
# > 만약 입력한 아이디가 중복된 아이디가 아니라면 비밀번호, 비밀번호 확인, 이메일을 입력하고
#   이메일로 인증 번호를 전송
# > 사용자는 이메일로 전송된 인증 번호를 확인 후 입력하여 이메일 인증을 진행
#   이메일 인증을 완료한 후에 회원가입 버튼을 눌러서 회원가입을 마무리

create table user (
	id varchar(100) primary key,
    password varchar(255) not null,
    email varchar (255) not null
); 

create table email_authentication(
	email varchar(255) primary key,
    authentication_code varchar(4) not null
);

-- 사용자가 아이디를 'awsd123'로 입력했다
-- 1. 아이디 중복확인
select * from user where id = 'awsd123';

-- 사용자가 비밀번호를 `qwe123', 비밀번호 확인을 'qwe123'
-- 이메일을 'email@email.com`, 서버가 생성한 코드는 'OCMD'dlek

-- 2. 이메일 인증
insert email_authentication values('email@email.com', 'OCMD');

-- 서버가 지정한 이메일로 인증코드를 전송하고 사용자는 그 코드를 확인한 후 인증코드를 입력함
-- 3. 이메일 인증 확인
select * from email_authentication
where email = 'email@email.com' and  authentication_code = 'ZSDD';

-- 4. 회원가입 처리
insert user values('awsd123', 'qwe123', 'email@email.com');

-- ================================================================
-- 트랜잭션 시작
show variables like '%commit%';
set autocommit = 0;

start transaction;
-- 사용자가 아이디를 'awsd123'로 입력했다
-- 1. 아이디 중복확인
select * from user where id = 'ksh03092';

-- 사용자가 비밀번호를 `qwe123', 비밀번호 확인을 'qwe123'
-- 이메일을 'email@email.com`, 서버가 생성한 코드는 'OCMD'dlek

-- 2. 이메일 인증
insert email_authentication values('email3@email.com', 'OCMD');

-- 트랜잭션 초기상태로 변경(트랜잭션 취소)
rollback;

-- 트랜잭션 롤백 위치 지정
savepoint A;

-- 서버가 지정한 이메일로 인증코드를 전송하고 사용자는 그 코드를 확인한 후 인증코드를 입력함
-- 3. 이메일 인증 확인
select * from email_authentication
where email = 'email3@email.com' and  authentication_code = 'ZSDD';

-- 4. 회원가입 처리
insert user values('ksh03092', 'qwe123', 'email3@email.com');

-- 특정 세이브 포인트로 롤백
rollback to savepoint A;

-- 트랜잭션 성공 처리(영구히 적용)
commit;

select * from user;							
select * from email_authentication;

-- ==================================================================
-- limit 개수: 결과테이블에서 지정한 개수만큼의 상위 데이터만 추출하여 보여줌
select * from jeju limit 10;		# 상위 10개
select * from jeju limit 10, 3;		# 상위 10개 이후의 3개








