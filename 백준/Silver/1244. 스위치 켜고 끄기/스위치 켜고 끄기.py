### input ###
S = int(input()) + 1 # 스위치 개수

# 스위치 상태 (0 비우기)
tmp = list(map(int, input().split()))
switch = [0] + tmp

st = int(input()) # 학생 수

# 스위치 상태 변경
def changeSwitch(i):
    if switch[i] == 1:
        switch[i] = 0 
    elif switch[i] == 0: 
        switch[i] = 1
    
for i in range(st): # 학생 수만큼 돌기
    # 학생 성별 / 학생이 받은 수
    gd, snum = map(int, input().split())

    # 남학생이면
    if gd == 1:
        for s in range(snum, S, snum): # snum에서 시작해서 snum 만큼 ++ (배수)
            # 스위치 상태 변경
            changeSwitch(s)
    # 여학생이면
    elif gd == 2: 
        # 학생이 받은 수를 기준으로 좌우를 +1, -1 하면서 스위치 값이 대칭(같은 값)인지 확인
        left = snum - 1
        right = snum + 1
        changeSwitch(snum)
        while (left > 0 and right < S) and (switch[left] == switch[right]): # 대칭이 아닐 때 까지
            changeSwitch(left)
            changeSwitch(right)
            left -= 1
            right += 1

### output ###
for i in range(1, S, 20):
    print(*switch[i:i+20])
