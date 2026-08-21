import java.util.*;
class Solution {
    class Node{
        int idx, priority;
        Node(int idx, int priority){
            this.idx = idx;
            this.priority = priority;
        }

    }
    
    static int N;
    public int solution(int[] priorities, int location) {
        N = priorities.length;
        ArrayDeque<Node> q = new ArrayDeque<>();
        for(int i = 0; i < N; i++){
            q.add(new Node(i, priorities[i]));
        }
        
        int result = 0;
        
        while(!q.isEmpty()){
            Node now = q.poll();
            if(check(now, q)){
                q.add(now);
            }
            else{
                result++;
                if(now.idx == location) break;
            }
        }
        
        return result;
    }
    
    public boolean check(Node now, ArrayDeque<Node> q){
        for(Node node : q){
            if(now.priority < node.priority) return true;
        }
        return false;
    }
}
