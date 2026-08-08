import java.util.*;
class Solution {
    static int N;
    static HashMap<String, Integer> cnt_map = new HashMap<>();
    static HashMap<String, ArrayList<Integer>> idx_map = new HashMap<>();
    public ArrayList<Integer> solution(String[] genres, int[] plays) {
        N = genres.length;
        for(int i = 0; i < N; i++){
            cnt_map.put(genres[i], cnt_map.getOrDefault(genres[i], 0) + plays[i]);
            if(!idx_map.containsKey(genres[i])) idx_map.put(genres[i], new ArrayList<>());
            idx_map.get(genres[i]).add(i);
        }
        
        for(String key : idx_map.keySet()){
            Collections.sort(idx_map.get(key), (a1, a2) -> {
                if(plays[a2] == plays[a1]) return Integer.compare(a1, a2);
                return Integer.compare(plays[a2], plays[a1]);
            });
        }
        
        ArrayList<String> genres_arr = new ArrayList<>(cnt_map.keySet());
        Collections.sort(genres_arr, (a1, a2) -> {
            return Integer.compare(cnt_map.get(a2), cnt_map.get(a1));
        });
        
        ArrayList<Integer> answer = new ArrayList<>();
        int size = idx_map.get(genres_arr.get(0)).size();
        for(int i = 0; i < genres_arr.size(); i++){
            int len = Math.min(2, idx_map.get(genres_arr.get(i)).size());
            for(int j = 0; j < len; j++) {
                answer.add(idx_map.get(genres_arr.get(i)).get(j));
            }
        }
        
        return answer;
    }
}
