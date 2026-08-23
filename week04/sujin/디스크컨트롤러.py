import heapq

def solution(jobs):
    answer = 0
    hq = []
    # 1. 요청 시간 기준으로 오름차순 정렬
    jobs.sort()
    
    N = len(jobs)
    cur_time, i, count = 0, 0, 0
    
    # 모든 작업을 처리할 때까지 반복
    while count < N:
        # 2. 현재 시간(cur_time) 이전에 요청된 모든 작업을 힙에 삽입
        while i < N and jobs[i][0] <= cur_time:
            heapq.heappush(hq, (jobs[i][1], jobs[i][0]))
            i += 1
        
        if hq:
            duration, start = heapq.heappop(hq)
            cur_time += duration
            answer += (cur_time - start)
            count += 1
        else:
            cur_time = jobs[i][0]
            
    return answer // N


print(solution([[0, 3], [1, 9], [3, 5]])) 