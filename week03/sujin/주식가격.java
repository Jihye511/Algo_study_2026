import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int [n];
        
        ArrayDeque<int[]> stack = new ArrayDeque<>();  

        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peekLast()[1] > prices[i]) {
                int[] newInfo = stack.pollLast();
                int idx = newInfo[0];
                answer[idx] = i - idx;
            }
            
            stack.add(new int[] {i, prices[i]});
        }
        
        while (!stack.isEmpty()) {
            int[] newInfo = stack.pollLast();
            int idx = newInfo[0];
            answer[idx] = n - idx - 1;
        }
        
        return answer;
    }
}