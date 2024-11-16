from collections import deque

R, C = map(int, input().split())

arr = []
for i in range(R):
    arr.append(list(map(str, input())))
visited = [[0] * C for _ in range(R)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs(index):
    queue = deque(index)
    while queue:
        a, ci, cj, level = queue.popleft()
        if a == '*':
            for i in range(4):
                ni = ci + dx[i]
                nj = cj + dy[i]
                if 0 <= ni < R and 0 <= nj < C:
                    if arr[ni][nj] == '.' or arr[ni][nj] == 'S':
                        arr[ni][nj] = '*'
                        queue.append([a, ni, nj, 0])
        elif a == 'S':
            for i in range(4):
                ni = ci + dx[i]
                nj = cj + dy[i]
                if 0 <= ni < R and 0 <= nj < C:
                    if visited[ni][nj] == 0 and arr[ni][nj] == '.':
                        queue.append([a, ni, nj, level + 1])
                        visited[ni][nj] = 1
                    elif arr[ni][nj] == 'D':  # 비버 찾았으면
                        return level + 1
    # 더 이상 방문할 배열이 없으면
    return 'KAKTUS'


ind = []

for i in range(R):
    for j in range(C):
        if arr[i][j] == '*':
            ind.append(['*', i, j, 0])
for i in range(R):
    for j in range(C):
        if arr[i][j] == 'S':
            ind.append(['S', i, j, 0])  # 시작점, 인덱스, level = 0

print(bfs(ind))
