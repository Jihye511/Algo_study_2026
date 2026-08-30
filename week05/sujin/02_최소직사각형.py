def solution(sizes):
    max_w = 0  # 모든 명함 중 긴 변들의 최댓값
    max_h = 0  # 모든 명함 중 짧은 변들의 최댓값
    
    for card in sizes:
        max_w = max(max_w, max(card))
        max_h = max(max_h, min(card))
        
    return max_w * max_h