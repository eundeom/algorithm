def solution(array):
    answer = 0
    array.sort()
    answer = array[round(len(array)//2)]
    return answer