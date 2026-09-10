from collections import defaultdict, deque

def solution(n, wires):
    answer = int(1e9)
    
    def bfs(info):
        visited = set()
        queue = deque([])
        cnt = 1
        start = 1
        queue.append((start)) 
        visited.add(start)
        
        while queue:
            cur = queue.popleft()
            for nxt in info[cur]:
                if nxt in visited:
                    continue
                queue.append((nxt))
                visited.add(nxt)
                cnt += 1
                
        return cnt
    
    for i in range(len(wires)):
        info = defaultdict(list)
        
        # 인접 리스트
        for j in range(len(wires)):
            if i == j:  # i번째 송전탑을 연결 끊기
                continue
            a, b = wires[j]
            info[a].append(b)
            info[b].append(a)
        
        size = bfs(info)
        answer = min(answer, abs((n-size) - (size)))
                
    return answer