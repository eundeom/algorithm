N = int(input())
arr = []
for i in range(N):
    temp = list(map(int, input()))
    arr.append(temp)

visited = [[0] * N for _ in range(N)]
d_num = 0

# 상하좌우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def dfs(si, sj): # 시작점
    h_num = 0
    visited[si][sj] = 1 # 시작점 방문 표시
    stack = [[si,sj]] # 스택: 방문할 곳 담은 배열 // 방문할 곳이 시작점 밖에 없음
    while stack: # 방문할 곳이 없을 때까지
        ci, cj = stack.pop() # 가장 마지막에 방문한 곳 = 현재 내가 있는 곳
        h_num += 1
        # print(ci, cj)
        for i in range(4):
            ni = ci + dx[i]
            nj = cj + dy[i]
            if 0 <= ni < N and 0 <= nj < N:
                if visited[ni][nj] == 0 and arr[ni][nj] == 1:
                    stack.append([ni,nj])
                    visited[ni][nj] = 1
    return h_num

# dfs(0,1)
# 0,1 - stack [1,1 0,2]
# 0,2 - stack [1,1 1,2]
# 1,2 - stack [1,1 2,2]
# 2,2 - stack [1,1 2,1]
# 2,1 - stack [1,1 2,0]
# 2,0 - stack [1,1]
# 1,1 - stack []

h_arr = []

for i in range(N):
    for j in range(N):
        if arr[i][j] == 1:
            if visited[i][j] == 0:
                # 상하좌우에 1 있는지 확인하기
                h_arr.append(dfs(i,j))
                d_num += 1

h_arr.sort()
print(d_num)
print(*h_arr, sep='\n')


            