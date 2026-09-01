import math
from itertools import permutations


def solution(numbers):
    answer = 0

    def check_prime_number(num):
        if num == 1 or num == 0:
            return False
        for i in range(2, int(math.sqrt(num)) + 1):
            if num % i == 0:
                return False
        return True
    n = list(numbers)

    a = []
    for i in range(1, len(n)+1):
        a += list(permutations(n, i))  # 경우의 수 반환

    b = []
    for i in a:
        b.append(int(''.join(i)))
    b = list(set(b))  # 경우의 수를 int형으로 담은 배열 b 선언

    count = 0
    for num in b:
        if check_prime_number(num):
            print(num)
            count += 1

    return count


