from collections import deque

# 전체 사람 수
n = int(input())

# 촌수 계산해야하는 사람 둘
a, b = map(int, input().split())

# 부모 자식 관계 개수 m
m = int(input())

graph = [[] for i in range(n+1)]
for i in range(m):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)
visited = [0 for _ in range(n+1)]

# 촌수 계산해야하는 사람 둘이 7 3 이면 7에서 양방향으로 연결된 그래프에서 3찾을 때까지
cnt = -1
def bfs(v):
    global cnt
    plevel = -1
    c_list = [] # 같은 그래프에 있는지 체크

    visited[v] = 1
    queue = deque([[v, 0]])
    while queue:
        c, clevel = queue.popleft()
        c_list.append(c)
        # 전 level과 현재 level이 같으면 cnt 안함
        if plevel != clevel:
            cnt += 1
            plevel = clevel
        if c == b: # b 찾으면 break
            break
        # if len(graph[c]) == 1:
        #     cnt -= 1
        for i in graph[c]:
            if visited[i] == 0: # 방문 안했어
                queue.append([i, clevel + 1])
                visited[i] = 1
    if not b in c_list:
        cnt = -1

bfs(a)
print(cnt)