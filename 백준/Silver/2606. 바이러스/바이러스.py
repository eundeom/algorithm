N = int(input()) # 컴퓨터의 수
M = int(input()) # 네트워크 상에 직접 연결되어 있는 컴퓨터 쌍의 수

graph = [[] for _ in range(N+1)]	



for n in range(M):
    a, b = map(int, input().split())
    # 양방향
    graph[a].append(b)
    graph[b].append(a)

visited = [False] * (N+1)
count = -1


def dfs(v):
    visited[v] = True
    global count
    count += 1
    for i in graph[v]:
        if not visited[i]:
            dfs(i)

dfs(1)
print(count)