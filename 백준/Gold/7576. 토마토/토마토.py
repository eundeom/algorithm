from collections import deque

# 상자 길이 input
M, N = map(int, input().split())

arr = []
for i in range(N):
    arr.append(list(map(int, input().split())))
visited = [[0]*M for _ in range(N)]

# 상하좌우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
 
# 배열 전체 돌기
# 하루 지나 토마토가 익음 -> 1인 토마토 주변 상하좌우 1로 바꾸기

def dfs(index):
    queue = deque([])
    for i in range(len(index)):
        queue.append(index[i])
    while queue:
        ci, cj = queue.popleft()
        for i in range(4):
            ni = ci + dx[i]
            nj = cj + dy[i]
            if 0 <= ni < N and 0 <= nj < M:
                if arr[ni][nj] == 0 and visited[ni][nj] == 0:
                    visited[ni][nj] = visited[ci][cj] + 1
                    queue.append([ni, nj])
                    arr[ni][nj] = 1

index = []
for i in range(N):
    for j in range(M):
        if arr[i][j] == 1:
            if visited[i][j] == 0:
                # 토마토 익기..
                index.append([i,j])
                visited[i][j] = 1
        elif arr[i][j] == -1:
            visited[i][j] = -1
dfs(index)





max_day = 0
flag = True
for i in range(N):
    for j in range(M):
        max_day = max(visited[i][j], max_day)

        if visited[i][j] == 0:
            max_day = 0
            flag = False
            break
    if flag == False:
        break

print(max_day-1)