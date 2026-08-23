import heapq

def solution(operations):
    max_heap = []
    min_heap = []
    visited = [False] * len(operations)
    
    for i, op in enumerate(operations):
        cmd, num = op.split()
        num = int(num)
        
        if cmd == 'I':
            heapq.heappush(min_heap, (num, i))
            heapq.heappush(max_heap, (-num, i))
            visited[i] = True
            
        elif cmd == 'D':
            if num == 1:
                while max_heap and not visited[max_heap[0][1]]:
                    heapq.heappop(max_heap)
                if max_heap:
                    visited[max_heap[0][1]] = False
                    heapq.heappop(max_heap)
            elif num == -1:
                while min_heap and not visited[min_heap[0][1]]:
                    heapq.heappop(min_heap)
                if min_heap:
                    visited[min_heap[0][1]] = False
                    heapq.heappop(min_heap)
                    
    while max_heap and not visited[max_heap[0][1]]:
        heapq.heappop(max_heap)
    while min_heap and not visited[min_heap[0][1]]:
        heapq.heappop(min_heap)
        
    if not max_heap or not min_heap:
        return [0, 0]
    else:
        return [-max_heap[0][0], min_heap[0][0]]