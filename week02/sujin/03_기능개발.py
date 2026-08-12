import math

def solution(progresses, speeds):
    answer = []
    
    remain = []
    for i in range(len(progresses)):
        remain.append(math.ceil((100-progresses[i]) / speeds[i]))
        
    max_days = remain[0]
    count = 1
    for i in range(1, len(remain)):
        
        if max_days < remain[i]:
            max_days = remain[i]
            answer.append(count)
            count = 1
        else:
            count += 1
    answer.append(count)
            
    
    print(remain)
    
    return answer