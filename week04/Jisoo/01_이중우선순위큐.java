import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        
        for(String op : operations){
            if (op.equals("D 1")){
                if(maxPQ.isEmpty()){
                    continue;
                }
                int max = maxPQ.poll();
                minPQ.remove(max);
            } else if (op.equals("D -1")){
                if(maxPQ.isEmpty()){
                    continue;
                }
                int min = minPQ.poll();
                maxPQ.remove(min);
                
            }
            else {
                maxPQ.offer(Integer.parseInt(op.substring(2)));
                minPQ.offer(Integer.parseInt(op.substring(2)));
            }
        }
        
        if(!maxPQ.isEmpty()) {
            answer[0] = maxPQ.peek();
            answer[1] = minPQ.peek(); 
        }
        
        
        return answer;
    }
}