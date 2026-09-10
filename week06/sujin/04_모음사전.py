def solution(word):
    cnt = 0
    candidates = ['A', 'E', 'I', 'O', 'U']
    flag = False
    cnt = 0
    answer = 0
    
    if word == 'A':
        return 1
    
    def dfs(wrd, depth):
        nonlocal cnt, flag, answer
        
        if depth == 5 or flag == True:
            return
        
        for i in range(5):
            cnt += 1
            new_word = wrd + candidates[i]
            
            if new_word == word:
                flag = True
                answer = cnt
                return
            
            dfs(new_word, depth + 1)

    
    dfs("", 0)
    
    return answer