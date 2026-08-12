import java.io.*;
import java.util.*;
class Solution {
    class Node{
        int genre; //해당 장르 우선순위 1이 가장 높음
        int idx; //고유번호
        int plays; //재생수
        String name; //장르
        public Node(int genre, int idx, int plays, String name){
            this.genre = genre;
            this.idx = idx;
            this.plays = plays;
            this.name = name;
        }
        
    }
    
    public int[] solution(String[] genres, int[] plays) {
        Node[] nodes = new Node[genres.length];
        //장르별 재생수
        HashMap<String, Integer> map = new HashMap<>();
        for(int i =0; i<genres.length; i++){
            String s = genres[i];
            int p = plays[i];
            map.put(s,map.getOrDefault(s, 0)+ p);
        }
        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet, (a,b)-> map.get(b) - map.get(a));
        for(int i =0; i< genres.length; i++){
            String g = genres[i];
            for(int j =0; j<keySet.size(); j++){
                if(keySet.get(j).equals(g)){
                    nodes[i] = new Node(j,i,plays[i],g);
                    break;
                }
            }
        }
        //정렬
        Arrays.sort(nodes, (a,b)->{
            if(a.genre == b.genre && a.plays == b.plays) return a.idx -b.idx;
            if(a.genre == b.genre) return b.plays - a.plays;
            return a.genre - b.genre;
        });
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<String, Integer> count = new HashMap<>();
        for(Node node : nodes){
            count.put(node.name, count.getOrDefault(node.name, 0)+1);
            if(count.get(node.name)<3){
                list.add(node.idx);
            }
            
        }
        int[] answer = new int[list.size()];
        for(int i =0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
