import java.io.*;
import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> waiting = new LinkedList<>();
        Queue<int[]> bridge = new LinkedList<>(); // 트럭 무게 , 나가는 시간
        for(int i : truck_weights){
            waiting.offer(i);
        }
        int hap = 0;
        int time=0;
        while(!waiting.isEmpty()){
            time++;
            int next = waiting.peek();
            //시간돼서 트럭 빼기
            if(!bridge.isEmpty() && bridge.peek()[1] ==time){
                int[] out = bridge.poll();
                hap -= out[0];
                time = out[1];
            }
            
            if(hap + next >weight){
                int[] out = bridge.poll();
                hap -= out[0];
                time = out[1];
            }
            if(hap + next <= weight){
                bridge.offer(new int[]{waiting.poll(), time+bridge_length}); 
                hap += next;
            }
            
        }
        if(!bridge.isEmpty()){
            while(!bridge.isEmpty()){
                answer = bridge.poll()[1];
            }
            
        }else answer = time;
        
        return answer;
    }
}
