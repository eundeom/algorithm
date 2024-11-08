# 전쟁터 가로 크기 N, 세로 크기 M
N, M = map(int, input().split())

arr = []
for i in range(M):
    arr.append(list(map(str, input())))
visited = [[0]*N for _ in range(M)]

# 상하좌우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def dfs(si, sj, find):
    cnt = 0
    visited[si][sj] = 1
    stack = [[si, sj]]
    while stack:
        ci, cj = stack.pop()
        cnt += 1
        for i in range(4):
            ni = ci + dx[i]
            nj = cj + dy[i]
            if 0 <= ni < M and 0 <= nj < N:
                if arr[ni][nj] == find and visited[ni][nj] == 0:
                    stack.append([ni, nj])
                    visited[ni][nj] = 1
    return cnt

wp = 0
bp= 0


# 전체 리스트를 돌면서 W인값과 B인값이면 탐색
for i in range(M):
    for j in range(N):
        if arr[i][j] == 'W' and visited[i][j] == 0:
            wp += ((dfs(i, j, 'W')) ** 2)
        if arr[i][j] == 'B' and visited[i][j] == 0:
            bp += ((dfs(i, j, 'B')) ** 2)

print(wp,bp)