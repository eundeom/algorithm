def solution(n):
    answer = 0
    if n <= 7:
        # n이 7보다 작으면
        answer = 1
    elif n > 7:
        answer = n//7
        if n%7 > 0:
            answer += 1
    return answer