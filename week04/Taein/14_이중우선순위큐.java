import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> max_pq = new PriorityQueue<>((a1, a2) -> Integer.compare(a2, a1));
        PriorityQueue<Integer> min_pq = new PriorityQueue<>();
        for(String operation : operations){
            String[] ord = operation.split(" ");
            int num = Integer.parseInt(ord[1]);
            if(ord[0].equals("I")){
                max_pq.add(num);
                min_pq.add(num);
            }
            else{
                if(max_pq.isEmpty()) continue;
                if(num == 1){
                    int temp = max_pq.poll();
                    min_pq.remove(temp);
                }
                else{
                    int temp = min_pq.poll();
                    max_pq.remove(temp);
                    
                }
            }
        }
        
        int[] answer = new int[2];
        if(!max_pq.isEmpty()) answer[0] = max_pq.poll();
        if(!min_pq.isEmpty()) answer[1] = min_pq.poll();
        
        
        return answer;
    }
}
