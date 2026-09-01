def solution(citations):
    answer = 0
    citations.sort(reverse=True)
    N = len(citations)
    
    for i in range(N):
        temp = min(citations[i], i + 1)
        answer = max(answer, temp)
    return answer