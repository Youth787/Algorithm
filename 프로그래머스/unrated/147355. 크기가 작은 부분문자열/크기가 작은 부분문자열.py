def solution(t, p): 
    d = len(t)-len(p)
    cnt = 0
    n = int(t) % (10**(len(p)))
    
    if int(p)>=n:
        cnt+=1
    
    for i in range(d):
        n = int(t)//(10**(i+1))
        k = int(n) % (10**(len(p)))
        if int(p) >= k :
            cnt +=1
            
    return cnt 