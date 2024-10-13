def solution(arr):
    answer = [0]
    answer[0] = arr[0] # 첫번째 숫자 append
    cnt = 0
    
    for i in range(1, len(arr)):
            if arr[i] == answer[cnt]:
                continue
            else: 
                answer.append(arr[i])
                cnt += 1
    return answer