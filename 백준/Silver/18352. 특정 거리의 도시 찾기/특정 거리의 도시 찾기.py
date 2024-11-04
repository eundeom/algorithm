from collections import deque

# 도시의 개수 N, 도로의 개수 M, 거리 정보 K, 출발 도시의 번호 X
N, M, K, X = map(int, input().split())

graph = [[] for _ in range(N+1)]
# 방문, 현재 거리
visited = [0 for _ in range(N+1)]


# 간선의 개수만큼 graph 입력 받기
for i in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)

arr = []
# 출발 도시 노드부터 최단 거리가 K인 도시 구하기
def dfs(v):
    visited[v] = 1 # 방문처리
    queue = deque([[v, 0]])
    while queue:
        # 현재 노드로부터 연결되어 있는 노드 queue에 넣고 방문처리 하기
        c, move = queue.popleft()
        if move == K:
            arr.append(c)
        for i in graph[c]:
            if visited[i] == 0 and move <= K:
                queue.append([i, move + 1])
                visited[i] = 1


dfs(X)

if len(arr) == 0:
    print(-1)
else:
    arr.sort()
    print(*arr, sep='\n')
