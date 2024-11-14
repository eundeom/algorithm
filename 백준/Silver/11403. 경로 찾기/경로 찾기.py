# 정점의 개수
N = int(input())

graph = []

for n in range(N):
    graph.append(list(map(int, input().split())))

# 단방향 그래프
g = [[] for i in range(N)]
for i in range(N):
    for j in range(N):
        if graph[i][j] == 1: # 간선이 존재함
            g[i].append(j)

def dfs(si, j):
    visited = [0 for _ in range(N)]
    visited[si] = 1
    if si == j:
        visited[si] = 0
        # 같은 수 flag
    stack = [si]
    while stack:
        ci = stack.pop()
        if ci == j and visited[si] != 0: # 현재 노드와 j가 같으면 연결된 노드가 있는거임! (양수인지 세야함)
            return 1
        if g[ci] == None:
            return 0
        for i in g[ci]:
            if not visited[i]:
                stack.append(i)
                visited[i] = 1
    # 없는거임
    return 0

res = [[0]*N for _ in range(N)]
# 0,0 ~ 2,2까지 돌기
for i in range(N): #0, 1, 2
    for j in range(N): #0, 1, 2
        res[i][j] = dfs(i, j)


for i in res:
    print(*i)


