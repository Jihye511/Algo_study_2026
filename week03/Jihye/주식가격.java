import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        Queue<Integer> q = new LinkedList<>();
        for(int i =0; i<prices.length; i++){
            q.offer(prices[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            int cur = q.poll();
            int cnt=0;
            for(int v : q){
                if(cur>v) {
                    cnt++;
                    break;
                }
                else{
                    cnt++;
                }
            }
            list.add(cnt);
            
        }
         int[] ans = new int[prices.length];
        for(int i =0; i<list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}
