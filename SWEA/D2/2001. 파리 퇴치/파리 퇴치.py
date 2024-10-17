T = int(input())

for test_case in range(1, T+1):
    N, M = map(int, input().split())

    arr = []
    for i in range(N):
        tmp = list(map(int, input().split()))
        arr.append(tmp)

    sum_num = 0
    max_num = 0

    for i in range(N-M+1):
        for j in range(N-M+1):
            sum_num = 0
            for row in range(M):
                for col in range(M):
                    sum_num += arr[row+i][col+j] 
            if sum_num > max_num:
                max_num = sum_num

    print(f'#{test_case} {max_num}')