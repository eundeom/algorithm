def solution(numbers):
    numbers.sort()
    numberslen = len(numbers)
    answer = numbers[numberslen-1]*numbers[numberslen-2]
    return answer