N, M, K = map(int, input().split())

# 0으로 초기화 한 배열
arr = [[0]*M for _ in range(N)]
visited = [[0]*M for _ in range(N)]

# 상하좌우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# 음식물 최대 값
max_num = 0

# 배열에 음쓰 좌표 입력 받아서 1로 수정
for k in range(K):
    a, b = map(int, input().split())
    a -= 1
    b -= 1
    arr[a][b] = 1

def dfs(si, sj):
    f_num = 0

    visited[si][sj] = 1
    stack = [[si, sj]]
    while stack:
        ci, cj = stack.pop() # 현재 노드
        f_num += 1
        # 상하좌우에 1인 노드 있는지 확인
        for i in range(4):
            ni = ci + dx[i]
            nj = cj + dy[i]
            if 0 <= ni < N and 0 <= nj < M:
                if arr[ni][nj] == 1 and visited[ni][nj] == 0:
                    stack.append([ni, nj])
                    visited[ni][nj] = 1
    global max_num
    max_num = max(max_num, f_num)

for i in range(N):
    for j in range(M):
        if arr[i][j] == 1:
            if visited[i][j] == 0:
                dfs(i, j)

print(max_num)