-- 동일 회원이 동일 상품 재구매한 데이터 구하기 -> 같은 user id, 같은 product id
-- 재구매한 회원 ID와 재구매한 상품 ID 출력하기
-- 결과 : 회원 ID를 기준으로 오름차순 정렬 + 회원 ID 같으면 상품 ID 기준으로 내림차순 정렬

-- SELECT user_id, product_id
-- FROM ONLINE_SALE
-- WHERE sales_amount > 1
-- ORDER BY user_id ASC, product_id DESC


-- 재구매 SQL : GROUP BY 
-- user id와 product id로 그룹 만듦 -> user id와 product id로 묶인 같은 컬럼 있으면 count
-- COUNT(*) 뜻 : 그룹 안에 몇 개의 행이 있는지 세는 함수 -> 그룹 : 같은 (USER_ID, PRODUCT_ID)로 이루어짐
SELECT USER_ID, PRODUCT_ID
FROM ONLINE_SALE
GROUP BY USER_ID, PRODUCT_ID 
HAVING COUNT(*) > 1
ORDER BY USER_ID ASC, PRODUCT_ID DESC