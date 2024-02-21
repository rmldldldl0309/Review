use practice_sql;

-- # 집계 함수: 레코드를 '그룹화'하여 하나의 결과를 반환하는 함수

-- 1. COUNT(): 특정 조건에 맞는 행의 개수를 반환
select count(*) from jeju;
select count(*) from jeju where speed_80m > 3;

-- 2. SUM(): 특정 컬럼의 값을 모두 합한 결과를 반환
select sum(speed_80m) from jeju;
select sum(speed_80m), sum(speed_70m) from jeju where observe_date like '2023-08-__';

-- 3. AVG(): 특정 컬럼의 값의 평균을 반환
select avg(speed_80m) from jeju;

-- 4. MAX() / MIN(): 특정 컬럼의 값의 최대 / 최소값을 반환
select max(speed_80m), min(speed_80m) from jeju;