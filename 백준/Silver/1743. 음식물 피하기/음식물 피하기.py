import sys
sys.setrecursionlimit(10**7)
# 통로의 세로 길이 N | 가로 길이 M | 음식물 쓰레기의 개수 K
N, M, K = map(int, input().split())

graph = [[0] * (M+1) for _ in range(N+1)]
visited = [[False] * (M+1) for _ in range(N+1)]
global size
size = 0
res = 0

# 1,1부터 다 돌아!! 그 노드에서 쓰레기 발견되면 인접한 곳에 쓰레기 있는지 확인
# 쓰레기 있으면 쓰레기 크기 증가시키고 방문 처리


for k in range(K): 
    a, b = map(int, input().split())
    graph[a][b] = 1


def dfs(x, y):
    global size

    # 범위를 벗어나면 False 반환
    if x < 0 or x > N or y < 0 or y > M:
        return False

    # 이미 방문했거나 쓰레기가 없는 경우
    if visited[x][y] or graph[x][y] == 0:
        return False
    
    # 쓰레기가 발견되면 처리
    size += 1
    visited[x][y] = True

    # 상, 하, 좌, 우로 연결된 노드 탐색
    dfs(x-1, y)
    dfs(x+1, y)
    dfs(x, y-1)
    dfs(x, y+1)

    return True

# N x M 배열 하나씩 돌면서 연결된 노드 있느느지 확인했으면 (True) res에 담고 최대값 비교
for i in range(N+1):
    for j in range(M+1):
        if dfs(i, j) == True:
            res = max(size, res)
            size = 0 # 다시 0으로 초기화

print(res)
