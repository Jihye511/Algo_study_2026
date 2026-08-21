import java.util.*;
class Solution {
    
    class Node{
        int idx, price;
        Node(int idx, int price){
            this.idx = idx;
            this.price = price;
        }
    }
    
    public int[] solution(int[] prices) {
        int N = prices.length;
        int[] result = new int[N];
        ArrayDeque<Node> q = new ArrayDeque<>();
        
        q.add(new Node(0, prices[0]));
        int cnt = 0;
        
        while(cnt < N - 1){
            cnt++;
            int len = q.size();
            for(int i = 0; i < len; i++){
                Node now = q.poll();
                if(now.price <= prices[cnt]){
                    q.add(now);
                }
                else{
                    result[now.idx] = cnt - now.idx;
                }
            }
            q.add(new Node(cnt, prices[cnt]));
        }
        
        if(!q.isEmpty()){
            while(!q.isEmpty()){
                Node now = q.poll();
                result[now.idx] = cnt - now.idx;
            }
        }
        
        return result;
    }
}
