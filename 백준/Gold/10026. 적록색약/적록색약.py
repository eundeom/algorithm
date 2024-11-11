N = int(input())

# 적록색약 아닌 사람 : 빨강 파랑 초록
# 적록색약 : 빨강=파랑, 초록 
# 그래프를 돌면서 R, G, B인 구역 수 각각 세기

# 상 하 좌 우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

arr = []
for i in range(N):
    arr.append(list(map(str, input())))
visited = [[0]*N for _ in range(N)]

rcnt = 0
gcnt = 0
bcnt = 0
xcnt = 0

def dfs(si, sj, color):
    visited[si][sj] = 1
    stack = [[si, sj]]
    while stack:
        ci, cj = stack.pop()
        for i in range(4):
            ni = ci + dx[i]
            nj = cj + dy[i]
            if 0 <= ni < N and 0 <= nj < N:
                if (arr[ni][nj] == color) and visited[ni][nj] == 0:
                    stack.append([ni, nj])
                    visited[ni][nj] = 1

for i in range(N):
    for j in range(N):
        if arr[i][j] == 'R' and visited[i][j] == 0:
            dfs(i, j, 'R')
            rcnt += 1
        elif arr[i][j] == 'G' and visited[i][j] == 0:
            dfs(i, j, 'G')
            gcnt += 1
        elif arr[i][j] == 'B' and visited[i][j] == 0:
            dfs(i, j, 'B')
            bcnt += 1
print(f'{rcnt+gcnt+bcnt}', end=' ')

visited = [[0]*N for _ in range(N)]
for i in range(N):
    for j in range(N):
        if arr[i][j] == 'R':
            arr[i][j] = 'G'


for i in range(N):
    for j in range(N):
        if (arr[i][j] == 'G') and visited[i][j] == 0:
            dfs(i, j, 'G')
            xcnt += 1


print(f'{bcnt+xcnt}')
