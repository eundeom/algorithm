from collections import deque

N, M, V = map(int, input().split())

graph = [[] for _ in range(N+1)]
visited = [0 for _ in range(N+1)]

for i in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[a].sort()
    graph[b].append(a)
    graph[b].sort()

def dfs(v):
    # V부터 방문된 점 순서대로 출력하기
    # v 방문 체크하기
    # v랑 연결된 노드 중 방문 안한 노드 배열에 넣기
    visited[v] = 1
    print(v, end=' ')
    for i in graph[v]:
        if visited[i] == 0:
            dfs(i)


def bfs(v):
    # v 방문 체크하기
    # queue에 남은 노드가 없을 때까지 v랑 연결된 방문 안 한 노드를 queue에 넣고 하나씩 방문하기
    visited[v] = 1
    queue = deque([v]) # 시작점
    while queue:
        cn = queue.popleft()
        print(cn, end=' ')
        for i in graph[cn]:
            if visited[i] == 0:
                queue.append(i)
                visited[i] = 1


dfs(V)
print('')
visited = [0 for _ in range(N+1)]
bfs(V)