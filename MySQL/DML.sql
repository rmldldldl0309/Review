-- ▶ DML (데이터 조작어)
# : 테이블에 데이터를 삽입, 조회, 수정, 삭제할때 사용

-- 1. INSERT: 테이블에 데이터를 삽입하는 명령어
# > 모든 열에 대해 데이터 삽입
# : INSERT INTO 테이블명 VALUES (데이터1, 데이터2, ...);
USE practice_sql;
INSERT INTO example_table 
values ('문자열데이터', '텍스트데이터', 15, 99.5, 150.1, true, '2024-02-05', now());

# > 특정 열에 대해 데이터 삽입 
# : INSERT INTO 테이블명 (컬럼명1, 컬럼명2, ...) VALUES (데이터1, 데이터2, ...);
INSERT INTO example_table (int_column, boolean_column)
value (17, 0);

-- 2. SELECT: 테이블에서 데이터를 조회할 때 사용하는 명령어
# > 모든 데이터 조회
# : SELECT * FROM 테이블명;
SELECT * FROM example_table;

# > 특정 컬럼 데이터 조회
# : SELECT 컬럼명1, 컬럼명2, ... FROM 테이블명;
SELECT int_column, text_column FROM example_table;

# > 특정 조건에 부합하는 데이터 조회
# : SELECT * FROM 테이블명 WHERE 조건식
SELECT int_column, text_column 
FROM example_table 
WHERE int_column = 15;

-- 3. UPDATE: 테이블에서 데이터를 수정할 때 사용하는 명령어
# : UPDATE 테이블명 SET 컬럼1 = 데이터1, 컬럼2 = 데이터2, ... [WHERE 조건];
UPDATE example_table SET boolean_column = false;
UPDATE example_table SET datetime_column = now() WHERE int_column = 17;
SELECT * FROM example_table;

-- 3. DELETE: 테이블에서 데이터를 삭제할 때 사용하는 명령어
# : DELETE FROM 테이블명 [WHERE 조건];
DELETE FROM example_table WHERE int_column = 17;
DELETE FROM example_table;

TRUNCATE TABLE example_table;  -- DDL (구조만 남기고 모두 삭제)

-- ==================================================================================
CREATE TABLE auto_table (
	idx INT AUTO_INCREMENT PRIMARY KEY,
    num INT
);

INSERT INTO auto_table (num) VALUES (0);
SELECT * FROM auto_table;
DELETE FROM auto_table;		-- 데이터만 삭제 > 다시 값 삽입했을 때 아까 할당받았던 값 이후의 값 할당
TRUNCATE TABLE auto_table;	-- 초기화 > 값 삽입했을 때 다시 1부터 할당

-- DROP: DDL, 테이블의 구조 전체를 제거
-- TRUNCATE: DDL, 테이블의 구조만 남기고 초기화
-- DELETE: DML, 테이블의 데이터만 삭제








