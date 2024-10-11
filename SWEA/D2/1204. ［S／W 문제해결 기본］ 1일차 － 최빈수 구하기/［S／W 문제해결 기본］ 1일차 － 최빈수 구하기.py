T = int(input())

for test_case in range(1, T+1):

    tc_num = int(input())

    st_score = list(map(int, input().split()))

    max_score = max(st_score) #최대값 구하기

    check = [0 for i in range(max_score+1)] #최대값 만큼 리스트 만들고 해당 수에 몇 번 나오는지 체크

    max_idx = 0
    result = 0

    for sc in st_score:
        check[sc] += 1
        if max_idx < check[sc]:
            max_idx = check[sc]
            result = sc
        # 최빈수가 같을 때 더 큰 수를 선택
        elif max_idx == check[sc] and sc > result:
            result = sc

    

    print(f'#{test_case} {result}')