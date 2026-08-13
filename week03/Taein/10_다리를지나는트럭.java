import java.util.*;

class Solution {
    
    class Node{
        int w, end_time;
        Node(int w, int end_time){
            this.w = w;
            this.end_time = end_time;
        }
        
        @Override
        public String toString(){
            return "w : " + w + " , end_time : " + end_time;
        }
    }
    
    static int N;
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        N = truck_weights.length;
        int now_w = 0;
        ArrayDeque<Node> q = new ArrayDeque<>();
        int cnt = 0;
        int idx = 0;
        int time = 0;
        while(cnt < N){
            time++;
            int len = q.size();
            for(int i = 0; i < len; i++){
                Node now = q.poll();
                if(now.end_time > time){
                    q.add(now);
                }
                else {
                    now_w -= now.w;
                    cnt++;
                }
                
                
            }
            
            if(idx < N){
                if(q.isEmpty() || now_w + truck_weights[idx] <= weight){
                    q.add(new Node(truck_weights[idx], time + bridge_length));
                    now_w += truck_weights[idx];
                    idx++;
                }
            }
        }
    
        return time;
    }
}
