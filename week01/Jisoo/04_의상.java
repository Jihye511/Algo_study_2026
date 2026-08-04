import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] closet : clothes){
            map.put(closet[1], map.getOrDefault(closet[1],0)+1);
        }
        
        for(int num : map.values()){
            answer *= num+1;
        }
        return answer-1;
    }
}