-- ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE
-- 동물의 아이디, 생물 종,      보호 시작일, 보호 시작 시 상태,    이름,  성별 및 중성화 여부

-- 동물 보호소에 들어온 모든 동물의 아이디와 이름, 보호 시작일을 이름 순으로 조회하는 SQL : ANIMAL_TYPE
-- 이름이 같은 동물 중에서는 보호를 나중에 시작한 동물을 먼저 보여줘야 합니다.

SELECT ANIMAL_ID, NAME, DATETIME
FROM ANIMAL_INS
GROUP BY ANIMAL_ID, NAME, DATETIME
ORDER BY NAME ASC, DATETIME DESC