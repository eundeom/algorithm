def solution(str1, str2):
    answer = 0
    str2len = len(str2)
    check = -1
    
    for s in range(len(str1)):
        temp = 0
        for t in range(len(str2)):
            if (s + t) < len(str1):
                if str1[s + t] == str2[t]:
                    temp += 1
                    if temp == str2len:
                        check = temp
                        break
                else:
                    temp = 0
                
    if check == str2len:
        answer = 1
    else:
        answer = 2
            
    return answer