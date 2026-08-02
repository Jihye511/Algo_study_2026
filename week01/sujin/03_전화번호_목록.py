def solution(phone_book):
    phone_book.sort()  # 번호를 사전순으로 정렬
    for i in range(len(phone_book) - 1):
        # 정렬된 상태에서 다음 번호가 현재 번호의 접두어인지 확인
        if phone_book[i + 1].startswith(phone_book[i]):
            return False
    return True