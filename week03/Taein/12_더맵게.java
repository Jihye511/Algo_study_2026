import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : scoville) pq.add(i);
        
        int result = 0;
        while(!pq.isEmpty()){
            if(pq.size() < 2) break;
            
            int first = pq.poll();
            if(first >= K) return result;
            int second = pq.poll();
            pq.add(first + second * 2);
            result++;
            
        }
        
        if(!pq.isEmpty()){
            int now = pq.poll();
            if(now < K) return -1;
            else return result;
        }
        
        return -1;
    }
}
