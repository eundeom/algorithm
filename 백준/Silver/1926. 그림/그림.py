# 세로 n, 가로 m
n, m = map(int, input().split())

arr = []
for i in range(n):
    arr.append(list(map(int, input().split())))
visited = [[0]*m for _ in range(n)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

max_num = 0
def dfs(si, sj):
    num = 0
    visited[si][sj] = 1
    stack = [[si, sj]]
    while stack:
        ci, cj = stack.pop()
        num += 1
        for i in range(4):
            ni = ci + dx[i]
            nj = cj + dy[i]
            if 0 <= ni < n and 0 <= nj < m:
                if arr[ni][nj] == 1 and visited[ni][nj] == 0:
                    stack.append([ni, nj])
                    visited[ni][nj] = 1
    global max_num
    max_num = max(num, max_num)

cnt = 0
# 배열을 돌면서 1이면 dfs
for i in range(n):
    for j in range(m):
        if arr[i][j] == 1:
            if visited[i][j] == 0:
                dfs(i, j)
                cnt += 1

print(cnt)
print(max_num)