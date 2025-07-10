-- ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE
-- 동물의 아이디, 생물 종,      보호 시작일, 보호 시작 시 상태,    이름,  성별 및 중성화 여부

-- 동물 보호소에 동물이 몇 마리 들어왔는지 조회하는 SQL 문

SELECT COUNT(*) AS count
FROM ANIMAL_INS
