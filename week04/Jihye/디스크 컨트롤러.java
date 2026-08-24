import java.io.*;
import java.util.*;
class Task{
    int time,start,id;
    public Task(int time, int start, int id){
        this.time =time;
        this.start = start;
        this.id = id;
    }
}
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<Task> pq = new PriorityQueue<>((a,b)->a.start - b.start); //시작 시간 순 정렬
        PriorityQueue<Task>  waitingPq= new PriorityQueue<>((a,b) -> {
            if(a.time ==b.time) return a.start - b.start;
            else return a.time - b.time;}); //소요시간 기준 정렬하는 대기 큐
        for(int i = 0; i<jobs.length; i++){
            int start = jobs[i][0];
            int time = jobs[i][1];
            pq.offer(new Task(time, start, i));
        }
        
        int cnt=0;//현재 진행 시간
        int[] workingtime = new int[jobs.length];
        //컨트롤러 돌리기
        while(true){
                if(pq.isEmpty() && waitingPq.isEmpty()) break;
                //for문 돌려서 시간에 해당되는애들 넣기
                int size= pq.size();
                for(int i =0; i<size; i++){
                    Task cur = pq.poll();   
                    if(cur.start<=cnt){
                        waitingPq.offer(cur);
                    }else{
                        pq.offer(cur);
                        break;
                    }
                }
                if(waitingPq.isEmpty()){
                    cnt++;
                    continue;
                }
                Task cur = waitingPq.poll();
                
                cnt += cur.time;
                workingtime[cur.id] = cnt - cur.start; 
            }
            int hap=0;
        for(int v : workingtime){
            hap +=v;
        }
        return (int)(hap/jobs.length);
            
    }
        
}
