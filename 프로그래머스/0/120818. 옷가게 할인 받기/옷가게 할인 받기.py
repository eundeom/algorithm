def solution(price):
    answer = 0
    if price < 100000:
        answer = price
    elif 100000 <= price and price < 300000:
        answer = price * 0.95
    elif 300000 <= price and price < 500000:
        answer = price * 0.9
    elif 500000 <= price:
        answer = price * 0.8
    else:
        answer = price
        
    return int(answer)