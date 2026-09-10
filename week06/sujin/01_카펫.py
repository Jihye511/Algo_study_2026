def solution(brown, yellow):
    total = brown + yellow
     
    for height in range(1, total + 1):
        if total % height != 0:
            continue
            
        width = total // height

        if (2 * width) + (2 * height) - 4 == brown:
            return [width, height]
                
    return answer