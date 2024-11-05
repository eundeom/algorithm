from collections import deque
# 노드의 개수 입력 받기
N = int(input()) # 7

# 트리
graph = [[] for _ in range(N+1)] # 1 ~ 7
visited = [0 for _ in range(N+1)] # 방문, 부모노드 저장

cnt = 0

for i in range(N-1):
    # 트리 입력받기
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

# dfs 돌면서 연결된 노드 visited 할 때 부모노드(현재 노드도 같이 저장)
def bfs(v):
    visited[v] = 1
    queue = deque([v])
    while queue:
        c = queue.popleft()
        # 현재 노드와 연결된 노드 queue에 넣기
        for i in graph[c]:
            if visited[i] == 0: # 방문 안했으면 방문해서 queue에 넣기
                queue.append(i)
                visited[i] = c # 부모노드 넣기
                
                global cnt
                cnt += 1
                if cnt == (len(visited)-2):
                    break

bfs(1)
for i in range(2, N+1):
    print(visited[i])