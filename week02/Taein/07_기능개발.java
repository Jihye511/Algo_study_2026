import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        int N = progresses.length;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0; i < N; i++){
            int temp = (100 - progresses[i]);
            temp = temp / speeds[i] + (temp % speeds[i] == 0 ? 0 : 1);
            q.add(temp);
        }
        while(!q.isEmpty()){
            int cnt = 1;
            int now = q.poll();
            while(!q.isEmpty()){
                if(q.peek() <= now){
                    q.poll();
                    cnt++;
                }
                else break;
            }
            answer.add(cnt);
        }
        
        
        return answer;
    }
}
