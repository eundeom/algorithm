T = int(input())

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

for test_case in range(T):
    # 배추밭 가로길이 M, 세로길이 N, 배추가 심어져 있는 위치의 개수 K
    M, N, K = map(int, input().split())

    # 배추밭
    cabbage = [[0]*M for _ in range(N)]
    visited = [[0]*M for _ in range(N)]

    # 배추 모여있는 곳 수
    lump = 0

    def dfs(si, sj):
        visited[si][sj] = 1
        stack = [[si, sj]]
        while stack:
            ci, cj = stack.pop()
            for i in range(4):
                ni = ci + dx[i]
                nj = cj + dy[i]
                if 0 <= ni < N and 0 <= nj < M:
                    if cabbage[ni][nj] == 1 and visited[ni][nj] == 0:
                        stack.append([ni, nj])
                        visited[ni][nj] = 1

    for k in range(K):
        x, y = map(int, input().split()) # 배추 좌표
        cabbage[y][x] = 1

    # 배추 덩어리 개수 확인
    for i in range(N):
        for j in range(M):
            if cabbage[i][j] == 1: # 배추 있음
                if visited[i][j] == 0: # 방문 안했으면
                    dfs(i, j)
                    lump += 1

    print(lump)


        
