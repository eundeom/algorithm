# input 다솜이 방 번호 
D = list(map(int, input()))
D.sort()

# 0 ~ 8까지 인덱스
check = [0 for _ in range(9)]
                 
for i in range(len(D)):
    if D[i] == 9:
        check[6] += 1
    else:
        check[D[i]] += 1

if check[6]%2 == 0:
    check[6] = int(check[6]/2)
else:
    check[6] = int(check[6]/2 + 1)

max_num = max(check)
print(max_num)