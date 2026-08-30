def solution(answers):
    p1 = [1, 2, 3, 4, 5]
    p2 = [2, 1, 2, 3, 2, 4, 2, 5]
    p3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    
    scores = [0, 0, 0]
    
    for idx, answer in enumerate(answers):
        if answer == p1[idx % len(p1)]:
            scores[0] += 1
        if answer == p2[idx % len(p2)]:
            scores[1] += 1
        if answer == p3[idx % len(p3)]:
            scores[2] += 1
            
    max_score = max(scores)
    
    result = []
    for i, score in enumerate(scores):
        if score == max_score:
            result.append(i + 1)
            
    return result