import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        
        int[] arr = new int[progresses.length];
        for(int i=0; i<progresses.length; i++){
            if ((100 - progresses[i]) % speeds[i] == 0){
                arr[i] = (100 - progresses[i]) / speeds[i];
            } else {
                arr[i] =  (100 - progresses[i]) / speeds[i] + 1;   
            }
        }
        
        int idx = 0;
        int cnt = 1;
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<arr.length; i++){
            if(arr[idx] >= arr[i]){
                cnt++;
            } else {
                list.add(cnt);
                idx = i;
                cnt = 1;
            }
            
        }
        list.add(cnt);
        
        int[] answer = new int[list.size()];
        for(int i=0; i< list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}