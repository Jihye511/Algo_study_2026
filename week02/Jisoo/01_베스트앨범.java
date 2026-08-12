import java.util.*;

class Solution {
    class Node {
        int idx;        // 고유번호
        int playNum;    // 재생수
     	
        public Node(int idx, int playNum) {
            this.idx = idx;
            this.playNum = playNum;
        }
        
        public int getIdx(){
            return idx;
        }
        public int getPlayNum(){
            return playNum;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        // 1. 장르별 총 재생횟수 누적
        HashMap<String, Integer> playCountMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            playCountMap.put(genre, playCountMap.getOrDefault(genre, 0) + play);
        }
        
        // 2. 장르별 노래 목록 수집
        HashMap<String, List<Node>> musicMap = new HashMap<>();
        
        for (String genre : playCountMap.keySet()) {
            List<Node> list = new ArrayList<>();
            for (int j = 0; j < genres.length; j++) {
                if (genres[j].equals(genre)) {
                    list.add(new Node(j, plays[j]));
                }
            }
            musicMap.put(genre, list); 
        }
        
        // 3.  총 재생횟수가 높은 장르 순서로 정렬하기
        List<String> genreSortList = new ArrayList<>(playCountMap.keySet());
        genreSortList.sort(Comparator.comparing(playCountMap::get).reversed()); // 장르
        
        
        // 4. 각 장르 내부 노래 정렬 후 최대 2개씩 결과 담기
        List<Integer> result = new ArrayList<>();
        for (String genre : genreSortList) {
            // 해당 장르 노래 리스트 
            List<Node> list = musicMap.get(genre);
            
            // 재생수 내림차순, 같다면 idx 오름차순 정렬
            list.sort(Comparator.comparing(Node::getPlayNum).reversed()
                     			.thenComparing(Node::getIdx));
                
            
            // 최대 2개까지 수록
            for (int i = 0; i < Math.min(2, list.size()); i++) {
                result.add(list.get(i).idx);
            }
        }
        
        // List -> int[] 변환
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}