-- ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE
-- 동물의 아이디, 생물 종,      보호 시작일, 보호 시작 시 상태,    이름,  성별 및 중성화 여부

-- 동물 보호소에 들어온 모든 동물의 정보를 ANIMAL_ID순으로 조회하는 SQL문을 작성

SELECT *
FROM ANIMAL_INS
GROUP BY ANIMAL_ID