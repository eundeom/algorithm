-- APNT_YMD,  APNT_NO,  PT_NO,  MCDP_CD, MDDR_ID, APNT_CNCL_YN, APNT_CNCL_YMD
-- 진료예약일시, 진료예약번호, 환자번호, 진료과코드, 의사ID,   예약취소여부,    예약취소날짜

-- 2022년 5월 예약 환자 수를 진료과코드 별로 조회
-- 컬럼명 : '진료과 코드', '5월예약건수'로 지정
-- 결과 : 진료과별 예약한 환자 수를 기준으로 오름차순 정렬, 예약 환자 수 같으면 진료과 코드 기준 오름차순 정렬

-- select * from appointment 

select MCDP_CD as "진료과 코드", COUNT(MCDP_CD) as "5월예약건수"
from appointment 
where APNT_YMD BETWEEN TO_DATE('2022-05-01', 'YYYY-MM-DD') AND TO_DATE('2022-05-31', 'YYYY-MM-DD')
group by MCDP_CD
order by COUNT(MCDP_CD) ASC, MCDP_CD ASC