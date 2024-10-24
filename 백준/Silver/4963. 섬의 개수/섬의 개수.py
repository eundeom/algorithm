# w : 너비 h : 높이
while True:
    w, h = map(int, input().split())
    if w == 0 and h == 0:
        break

    # input
    arr = []
    for i in range(h):
        temp = list(map(int, input().split()))
        arr.append(temp)

    # 방문처리 배열
    visited = [[0]*w for _ in range(h)]

    # 상하좌우 대각선 확인
    dx = [-1, -1, -1, 0, 0, 0, 1, 1, 1]
    dy = [-1, 0, 1, -1, 0, 1, -1, 0, 1]

    # 1. 지도 전체 방문
    # 2. 하나씩 방문 하면서 
    #     1. 섬(1)이면 
    #         1. 섬개수 +1
    #         2. 연결된 노드(상하좌우대각선)가 1인지 확인
    #         3. 1이고 방문 안했으면 방문할 배열에 넣기

    def dfs(si, sj):
        # 방문 처리
        visited[si][sj] = 1
        # 방문할 배열에 시작점 넣기
        stack = [[si, sj]]
        while stack: # 방문할 배열에 노드가 없을 때까지
            ci, cj = stack.pop() # 현재 인덱스
            # 현재 인덱스와 연결된 노드가 1인지 확인 (상하좌우 + 대각선)
            for i in range(9):
                ni = ci + dx[i]
                nj = cj + dy[i]
                if 0 <= ni < h and 0 <= nj < w:
                    if arr[ni][nj] == 1 and visited[ni][nj] == 0:
                        stack.append([ni, nj])
                        visited[ni][nj] = 1

    # 섬 개수 카운트
    i_num = 0
    for i in range(h):
        for j in range(w):
            if arr[i][j] == 1:
                if visited[i][j] == 0: # 방문 안했으면
                    # dfs
                    dfs(i, j)
                    i_num += 1
    print(i_num)