from collections import Counter
def solution(participant, completion):
    p_dict = Counter(participant)
    c_dict = Counter(completion)
    for name, count in p_dict.items():
        if c_dict[name] != count:
            return name
