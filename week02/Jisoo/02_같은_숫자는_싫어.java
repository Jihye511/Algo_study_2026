import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        
        List<Integer> list = new ArrayList<>();
        for(int num : arr){
            if(list.size()==0){
                list.add(num);
            } else if(list.getLast() != num) {
                list.add(num);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}