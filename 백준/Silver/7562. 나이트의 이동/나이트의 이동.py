from collections import deque

T = int(input())

# 나이트가 이동할 수 있는 칸
dx = [-2, -1, 1, 2, 2, 1, -1, -2]
dy = [-1, -2, -2, -1, 1, 2, 2, 1]


# 최소 나이트가 움직일 수 있는 수
min_num = 0

for test_case in range(T):
    # 체스판 한 변의 길이
    l = int(input())
    # 체스판 초기화
    chess = [[0]*l for _ in range(l)]
    visited = [[0]*l for _ in range(l)]

    # 현재 나이트의 위치
    cx, cy = map(int, input().split())
    # 이동하려고 하는 위치
    lx, ly = map(int, input().split())


    # 현재 나이트 위치에서 이동할 수 있는 칸을 queue에 넣고 탐색
    def dfs(si, sj):
        if cx == lx and cy == ly:
            return 0
        visited[si][sj] = 1
        queue = deque([[si, sj, 1]])
        while queue:
            ci, cj, cmove = queue.popleft()
            for i in range(8):
                ni = ci + dx[i]
                nj = cj + dy[i]
                if ni == lx and nj == ly:
                    return cmove
                if 0 <= ni < l and 0 <= nj < l:
                    if visited[ni][nj] == 0:
                        queue.append([ni, nj, cmove+1])
                        visited[ni][nj] = 1
        print(min_num)
        min_num = min(min_num, cmove)
        return min_num

    # 현재 나이트의 위치 ~ 이동하려고 하는 위치까지
    print(dfs(cx, cy))

    
