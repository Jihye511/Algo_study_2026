import java.io.*;
import java.util.*;

/**
 * Map -> keySet으로 List -> map.get(key) 기준으로 sort
 * => value 기준으로 정렬된 key 목록 생성 가능
 */

class Music {
    int n;
    int count;

    public Music() {}
    public Music(int n, int count) {
        this.n = n;
        this.count = count;
    }
}

class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();

        Map<String, Integer> total = new HashMap<>();
        Map<String, List<Music>> music = new HashMap<>();
        for (int i=0; i<genres.length; ++i) {
            total.put(genres[i], total.getOrDefault(genres[i], 0) + plays[i]);

            if (!music.containsKey(genres[i])) {
                music.put(genres[i], new ArrayList<>());
            }
            music.get(genres[i]).add(new Music(i, plays[i]));
        }

        List<String> keys = new ArrayList<>(total.keySet());
        keys.sort((o1, o2) -> {
            return Integer.compare(total.get(o2), total.get(o1));
        });

        for (String key : keys) {
            List<Music> m = music.get(key);
            m.sort((o1, o2) -> Integer.compare(o2.count, o1.count));
            for (int i=0; i<m.size() && i < 2; ++i) {
                answer.add(m.get(i).n);
            }
        }


        return answer;
    }
}