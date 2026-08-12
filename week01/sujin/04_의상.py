from collections import defaultdict

def solution(clothes):
    info_cnt = defaultdict(int)
    for _, category in clothes:
        info_cnt[category] += 1  # 카테고리별 옷 개수 누적

    answer = 1
    for count in info_cnt.values():
        answer *= (count + 1)  # 각 카테고리에서 안 입는 경우를 포함하여 곱셈

    return answer - 1  # 아무 것도 안 입는 경우 제외