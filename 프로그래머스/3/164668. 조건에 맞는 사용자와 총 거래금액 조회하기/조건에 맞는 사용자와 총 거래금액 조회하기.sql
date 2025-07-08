-- 중고 거래 게시판 정보 : USED_GOODS_BOARD
-- BOARD_ID, WRITER_ID, TITLE,    CONTENTS, PRICE, CREATED_DATE, STATUS, VIEWS
-- 게시글 ID,  작성자 ID,  게시글 제목, 게시글 내용, 가격,    작성일,        거래상태, 조회수

-- 중고 거래 게시판 사용자 정보 : USED_GOODS_USER
-- USER_ID, NICKNAME, CITY, STREET_ADDRESS1, STREET_ADDRESS2, TLNO
-- 회원 ID,  닉네임,     시,    도로명 주소,       상세 주소,          전화번호

-- 완료된 중고 거래의 총금액이 70만 원 이상인 사람의 회원 ID, 닉네임, 총거래금액을 조회
-- 총거래금액을 기준으로 오름차순 정렬

-- select * from USED_GOODS_BOARD
-- select * from USED_GOODS_USER

-- 판매자 기준 판매 완료된 중고 거래의 총 금액 
-- select WRITER_ID, sum(price), status 
-- from USED_GOODS_BOARD
-- where status = 'DONE'
-- group by WRITER_ID, status
-- HAVING sum(price) >= 700000


select b.WRITER_ID as USER_ID, u.NICKNAME, sum(price) AS TOTAL_SALES
from USED_GOODS_BOARD b, USED_GOODS_USER u
where status = 'DONE' AND b.WRITER_ID = u.USER_ID
group by b.WRITER_ID, status, u.NICKNAME
HAVING sum(price) >= 700000
ORDER BY sum(price) ASC

-- sangyoung58, dhfkzmf09
-- select * from USED_GOODS_BOARD where writer_id = 'sangyoung58'
-- select * from USED_GOODS_USER where user_id = 'sangyoung58'