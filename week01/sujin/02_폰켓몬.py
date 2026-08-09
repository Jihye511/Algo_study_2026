def solution(nums):

    way = len(nums) // 2
    new_nums = set(nums)
    
    if len(new_nums) < way:
        return len(new_nums)
    return way