from collections import deque

N, M = map(int, input().split())

# N x M 배열 입력 받기
graph = []
for i in range(N):
    temp = list(map(int, input()))
    graph.append(temp)


visited = [[0]*(M) for _ in range(N)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(si, sj, cnt):
    visited[si][sj] == 1
    arr = deque([[si, sj, cnt]]) # 방문할 노드가 담긴 배열 - 현재 인덱스 담기
    while arr: # 방문할 노드가 없을 동안
        ### 현재 노드 ###
        ci, cj, cnt = arr.popleft() 
        cnt += 1
        if ci == N - 1 and cj == M - 1:
            return cnt
        ### 연결된 노드 ### 
        # 현재 노드와 연결된 노드가 1인지, 방문 안했는지 확인
        for i in range(4):
            ni = ci + dx[i]
            nj = cj + dy[i]
            if 0 <= ni < N and 0 <= nj < M:
                if graph[ni][nj] == 1 and visited[ni][nj] == 0:
                    arr.append([ni, nj, cnt])
                    visited[ni][nj] = 1 # 방문처리

print(bfs(0, 0, 0))