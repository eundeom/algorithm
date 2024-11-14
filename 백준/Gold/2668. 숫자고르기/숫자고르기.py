N = int(input())
graph = [0 for _ in range(N+1)]
for i in range(1, N+1):
    graph[i] = int(input())
# print(graph)

result = []
for n in range(1, N+1):
    index = graph[n]
    if graph[index] == n:
        result.append(n)

visited = [0 for _ in range(N+1)]

def dfs(v):
    v_list = [v]
    result = []

    visited[v] = 1
    stack = [v]
    while stack:
        c = stack.pop()
        result.append(c)
        v_list.append(c)
        if graph[c] == v: # 원래 내 숫자가 나오면 break
            visited[c] = 1
            return result
        if not visited[graph[c]]:
            stack.append(graph[c])
            visited[c] = 1
    # stack에 더이상 방문할 곳 없다 = 원래 내 숫자가 나오지 않음.. -> visited 취소하기 ㅜㅜ
    for v in v_list:
        visited[v] = 0

res = []
tmp = 0
for i in range(1, N+1):
    if visited[i] == 0:
        tmp = dfs(i)
        if tmp != None:
            res.append(tmp)

final = []
for r in res:
    for i in range(len(r)):
        final.append(r[i])

final.sort()
print(len(final))
print(*final, sep='\n')
