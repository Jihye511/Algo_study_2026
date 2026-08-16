import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for(int s : scoville){
            pQ.offer(s);
        }
        while(!pQ.isEmpty() && pQ.size() >= 2){
            if(pQ.peek() >= K){
                break;
            }
            int new_s = pQ.poll() + (pQ.poll() * 2);
            pQ.offer(new_s);
            answer++;
        }
        
        if(pQ.peek() < K){
            answer = -1;
        }
        
        return answer;
    }
}