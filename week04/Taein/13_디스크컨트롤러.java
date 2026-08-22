import java.util.*;
class Solution {
    
    class Node{
        int idx, start_time, lead_time;
        Node(int idx, int start_time, int lead_time){
            this.idx = idx;
            this.start_time = start_time;
            this.lead_time = lead_time;
        }
    }
    public int solution(int[][] jobs) {
        PriorityQueue<Node> ready_pq = new PriorityQueue<>((a1, a2) -> {
            return Integer.compare(a1.start_time, a2.start_time);
        });
        PriorityQueue<Node> disk_pq = new PriorityQueue<>((a1, a2) -> {
            if(a1.lead_time == a2.lead_time){
                if(a1.start_time == a2.start_time){
                    return Integer.compare(a1.idx, a2.idx);
                }
                return Integer.compare(a1.start_time, a2.start_time);
            }
            return Integer.compare(a1.lead_time, a2.lead_time);
        });
        
        for(int i = 0; i < jobs.length; i++){
            ready_pq.add(new Node(i, jobs[i][0], jobs[i][1]));
        }
        
        int time = 0;
        int result = 0;
        while(!ready_pq.isEmpty()){
            while(!ready_pq.isEmpty()){
                if(ready_pq.peek().start_time <= time) disk_pq.add(ready_pq.poll());
                else break;
            }
            if(disk_pq.isEmpty()) time++;
            else {
                Node now = disk_pq.poll();
                time += now.lead_time;
                result += (time - now.start_time);
            }
        }
        
        while(!disk_pq.isEmpty()){
            Node now = disk_pq.poll();
            time += now.lead_time;
            result += (time - now.start_time);
        }

        return result / jobs.length;
    }
}
