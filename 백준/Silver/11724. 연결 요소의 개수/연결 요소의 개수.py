import sys

sys.setrecursionlimit(10**6)
input=sys.stdin.readline

N, M = map(int, input().split())

cnt = 0


graph = [[] for _ in range(N+1)]
visited = [0 for _ in range(N+1)]
for m in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def dfs(v):
    visited[v] = 1
    stack = [v]
    while stack:
        c = stack.pop()
        for i in graph[c]:
            if not visited[i]:
                stack.append(i)
                visited[i] = 1
    

for i in range(N):
    if not visited[i] and i != 0:
        dfs(i)
        cnt += 1

for i in range(len(visited)):
    if visited[i] == 0 and i != 0:
        cnt += 1

if M == 0:
    cnt = N
    
print(cnt)