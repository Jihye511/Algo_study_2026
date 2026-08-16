from collections import deque

def solution(priorities, location):
    queue = deque([(p, i) for i, p in enumerate(priorities)])
    answer = 0
    
    while queue:
        current = queue.popleft()
        if any(current[0] < item[0] for item in queue):
            queue.append(current)
        else:
            answer += 1
            if current[1] == location:
                return answer