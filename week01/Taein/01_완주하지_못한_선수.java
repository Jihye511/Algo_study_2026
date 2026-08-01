import java.util.*;
class Solution {
    static HashMap<String, Integer> map = new HashMap<>();
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        for(String name : completion){
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        
        for(String name : participant){
            int num = map.getOrDefault(name, 0) - 1;
            if(num < 0){
                answer = name;
                break;
            }
            map.put(name, num);
        }
        
        return answer;
    }
}
