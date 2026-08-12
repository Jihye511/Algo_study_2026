def solution(arr):
    n = len(arr)
    num = arr[0]
    answer = [num]
    
    for i in range(1, n):
        if arr[i] == num:
            continue
            
        num = arr[i]
        answer.append(num)
    
    
    return answer