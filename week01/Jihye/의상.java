import java.io.*;
import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map =new HashMap<>();
        for(int i =0; i<clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1],0)+1);
        }
        List<String> key = new ArrayList<>(map.keySet());
        for(String k : key){
            int n = map.get(k);
            answer *= (n+1);
        }
        
        return answer-1;
    }
}
