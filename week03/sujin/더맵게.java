import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int n = scoville.length;
        for (int i = 0; i < n; i++) {
            pq.add(scoville[i]);
        }
        
        int cnt = 0;
        
        while (pq.peek() < K) {
            if (pq.size() < 2) {
                return -1;
            }
            int first = pq.poll();
            int second = pq.poll();
            
                pq.add(first + (second * 2));
                answer += 1;

            
        }
        return answer;
    }
}