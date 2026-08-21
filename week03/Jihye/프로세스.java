import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> waitPq = new PriorityQueue<>((a,b)->b-a);
        Queue<int[]> q = new LinkedList<>(); // 우선순위, 인덱스
        for(int i=0; i<priorities.length; i++){
            q.offer(new int[]{priorities[i],i});
            waitPq.offer(priorities[i]);
        }
        
        while(!q.isEmpty() && !waitPq.isEmpty()){
            if(q.peek()[0] == waitPq.peek()){
                answer++;
                waitPq.poll();
                int[] temp = q.poll();
                if(temp[1] == location){
                    break;
                }
            }else{
                int[] n = q.poll();
                q.offer(n);
            }
            
        }
        
        
        return answer;
    }
}
