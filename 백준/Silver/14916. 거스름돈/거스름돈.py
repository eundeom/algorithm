# 거스름돈의 개수
N = int(input())

cnt = 0
while N != 0:
    if N % 5 == 0:
        N -= 5
        cnt += 1
    else:
        N -= 2
        cnt += 1

    if N < 0:
        cnt = -1
        break

print(cnt)