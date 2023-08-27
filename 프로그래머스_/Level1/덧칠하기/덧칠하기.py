def solution(n, m, section):
    result = 1
    loc = section[0]+m-1
    for i in range(1,len(section)):
        if section[i] > loc:
            loc = section[i]+m-1
            result += 1
        
    return result