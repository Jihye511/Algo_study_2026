from collections import deque

def solution(k, dungeons):
    answer = 0
    n = len(dungeons)
    dungeons.sort(key= lambda x: (x[1], x[0]))
    hp = k
    
    def bfs():
        nonlocal answer, hp
        queue = deque([(hp, set(), 0)])
        
        while queue:
            hp, visited, depth = queue.popleft()
                
            for i in range(n):
                answer = max(depth, answer)
                    
                if i in visited or hp < dungeons[i][0]:
                    continue
                    
                nxt_hp = hp - dungeons[i][1]  # 소모 피로도
                new_visited = set(visited)
                new_visited.add(i)
                queue.append((nxt_hp, new_visited, depth + 1))
            
    bfs()
    
    return answer

