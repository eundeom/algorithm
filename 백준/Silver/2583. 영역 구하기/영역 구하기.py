# M x N // K : 직사각형 개수
N, M, K = map(int, input().split())

graph = [[0]*N for _ in range(M)]
visited = [[0]*N for _ in range(M)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

for k in range(K):
    # 직사각형 개수만큼 모눈종이에 그리기
    x, y, a, b = map(int, input().split())
    # a -= 1
    # b -= 1

    # (x,y) 노드부터 (a-1, b-1) 노드까지 그리기!
    for i in range(x, a):
        for j in range(y, b):
            graph[i][j] = 1 # 직사각형 색칠

# 빈 영역 내 노드 개수 세기
narr = []
def dfs(si, sj):
    node = 0
    visited[si][sj] = 1
    stack = [[si, sj]]
    while stack:
        ci, cj = stack.pop()
        node += 1
        for i in range(4):
            ni = ci + dx[i]
            nj = cj + dy[i]
            if 0 <= ni < M and 0 <= nj < N:
                if graph[ni][nj] == 0 and visited[ni][nj] == 0:
                    stack.append([ni, nj])
                    visited[ni][nj] = 1
    narr.append(node)

cnt = 0
# (0,0)부터 돌면서 graph == 0인 노드 덩어리 몇 개인지 탐색
for i in range(M):
    for j in range(N):
        if graph[i][j] == 0:
            if visited[i][j] == 0:
                dfs(i, j)
                cnt += 1

print(cnt)
narr.sort()
print(*narr)