
# input - N
N = int(input())

# input - 2차원 배열
arr = []
min_num = 100
max_num = 0
for i in range(N):
    temp = list(map(int, input().split()))
    arr.append(temp)

    # 가장 작은 수와 가장 큰 수 구하기
    ntemp = temp.copy()
    ntemp.sort()
    if min_num > ntemp[0]:
        min_num = ntemp[0]
    if max_num < ntemp[N-1]:
        max_num = ntemp[N-1]


# new arr 2차원 배열
new_arr = [[0]*N for _ in range(N)]
# 방문 체크 배열
visited = [[0]*N for _ in range(N)]
# 상하좌우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
# 안전지대 개수
safe = 0
# 최대 안전지대 개수
max_safe = 0

def dfs(si, sj):
    visited[si][sj] = 1
    stack = [[si, sj]]
    while stack:
        ci, cj = stack.pop()
        for i in range(4):
            ni = ci + dx[i]
            nj = cj + dy[i]
            if 0 <= ni < N and 0 <= nj < N: # 인접 노드가 범위 내
                if new_arr[ni][nj] == 0 and visited[ni][nj] == 0: # 인접 노드가 0(침수 안됨)이고 방문 안했으면
                    stack.append([ni, nj])
                    visited[ni][nj] = 1

# 배열 돌면서 검사
for F in range(max_num): # 숫자 2부터 9-1까지 검사
    # 초기화
    safe = 0
    new_arr = [[0]*N for _ in range(N)]
    visited = [[0]*N for _ in range(N)]

    # 침수된 노드는 1 침수 안된 노드는 0
    for i in range(N):
        for j in range(N):
            if arr[i][j] <= F: # 현재 숫자 2 이하이면
                new_arr[i][j] = 1 # 1로 바꿈 = 침수 됐다는 뜻

    # 다 바꿔서 dfs
    for i in range(N):
        for j in range(N):
            if new_arr[i][j] == 0: # 0이고 방문 안했으면 인접 노드들도 확인하기
                if visited[i][j] == 0:
                    dfs(i, j)
                    safe += 1
                
    if max_safe < safe:
        max_safe = safe

    



print(max_safe)