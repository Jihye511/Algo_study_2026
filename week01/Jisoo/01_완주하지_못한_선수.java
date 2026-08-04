import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String,Integer> map = new HashMap<>();
        
        for(String str : completion) {
            map.put(str,map.getOrDefault(str,0)+1);
        }
        
        for(String runner : participant){
            if(map.getOrDefault(runner,0) == 0){
                return runner;
            } else{
                map.put(runner,map.get(runner)-1);
            }
        }
        
        return answer;
    }
}