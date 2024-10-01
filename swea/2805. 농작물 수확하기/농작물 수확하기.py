T = int(input())


for test_case in range(1, T+1):
    # 농장 크기 = n
    n = int(input())
    farm = []
    val_sum = 0
    a = n//2 
    b = n//2

    # 농작물 가치
    for i in range(n):
        farm.append(list(map(int, input())))

    for line in range(n):
        for i in range(a, b+1):
            val_sum += farm[line][i]
        if (line+1) <= (n//2):
            a -= 1
            b += 1
        elif (line+1) > (n//2):
            a += 1
            b -= 1
    
    print(f'#{test_case} {val_sum}')
