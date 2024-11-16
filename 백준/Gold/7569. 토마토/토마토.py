from collections import deque

M, N, H = map(int, input().split())

arr = [[] for _ in range(H)]
for i in range(H):
    for j in range(N):
        arr[i].append(list(map(int, input().split())))
# visited= [[[0]*M]*N for _ in range(H)]
# visited= [[[0]*M for _ in range(N)] for _ in range(H)]

visited = [[[0 for _ in range(M)] for _ in range(N)] for _ in range(H)]

# 위아래상하좌우
dx = [-1, 1, 0, 0, 0, 0] # H
dy = [0, 0, -1, 1, 0, 0] # N
dz = [0, 0, 0, 0, -1, 1] # M

def bfs(index):
    tomato_max = 0
    # 방문 처리
    queue = deque(index)
    while queue:
        x, y, z, level = queue.popleft()

        for i in range(6):
            nx = x + dx[i]
            ny = y + dy[i]
            nz = z + dz[i]
            if 0 <= nx < H and 0 <= ny < N and 0 <= nz < M:
                if arr[nx][ny][nz] == 0 and visited[nx][ny][nz] == 0:
                    # 토마토 익히기
                    queue.append([nx, ny, nz, level + 1])
                    visited[nx][ny][nz] = level + 1
                    tomato_max = max(tomato_max, level+1)

    for i in range(H):
        for j in range(N):
            for x in range(M):
                if visited[i][j][x] == 0:
                    return -1
    # 0이 없음 - 토마토 다 익음
    return tomato_max


# 배열을 돌면서 1이 있으면 list에 넣기
ind = []
cnt1 = 0
cnt2 = 0
for i in range(H):
    for j in range(N):
        for x in range(M):
            if arr[i][j][x] == 1:
                ind.append([i, j, x, 0])
                visited[i][j][x] = 1
                cnt1 += 1
            elif arr[i][j][x] == -1:
                visited[i][j][x] = 1
                cnt2 += 1
                cnt1 += 1

if cnt2 == H*M*N:
    print(-1)
elif cnt1 == H*M*N:
    print(0)
else:
    print(bfs(ind))