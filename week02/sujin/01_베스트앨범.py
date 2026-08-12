from collections import defaultdict

def solution(genres, plays):
    answer = []
    total_plays_by_genre = defaultdict(int)
    songs_by_genre = defaultdict(list)
    
    for i in range(len(genres)):
        total_plays_by_genre[genres[i]] += plays[i] # 총 재생 횟수
        songs_by_genre[genres[i]].append((plays[i], i))  # (재생 횟수, 고유 번호) 저장
    
    
    sorted_genres = sorted(total_plays_by_genre.items(), key=lambda x: x[1], reverse=True)
    
    for genre, _ in sorted_genres:
        songs_by_genre[genre].sort(key=lambda x: (-x[0], x[1])) # 재생횟수는 높은 순, 고유 번호는 낮은 순
        for i in range(min(2, len(songs_by_genre[genre]))): # 최대 2개 혹은 리스트 길이 만큼
            answer.append(songs_by_genre[genre][i][1])  # 고유 번호를 저장
    
    return answer