import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer>list= new ArrayList<>();
        for(int i =0; i<progresses.length; i++){
            int days = (100- progresses[i])/speeds[i];
            if((100-progresses[i])%speeds[i]!=0) days+=1;
            
            q.offer(days);
        }
        while(!q.isEmpty()){
            int cur= q.poll();
            int cnt=1;
            while(!q.isEmpty() && cur>= q.peek()){
                q.poll();
                cnt++;
            }
            list.add(cnt);
        }
    
        answer = new int[list.size()];
        for(int i =0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
