from collections import deque

N, M, K, X = map(int, input().split())

graph = [[] for _ in range(N+1)]
for i in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
visited = [0 for _ in range(N+1)]

k_list = []
def bfs(v):
    visited[v] = 1
    q = deque([[v, 0]])
    while q:
        c, d = q.popleft()
        if d == K:
            k_list.append(c)

        for i in graph[c]:
            if not visited[i]:
                q.append([i, d+1])
                visited[i] = 1

bfs(X)
if len(k_list) == 0:
    print(-1)
else:
    k_list.sort()
    print(*k_list, sep='\n')
