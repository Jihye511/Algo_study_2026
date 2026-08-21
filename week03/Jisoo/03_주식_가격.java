import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {

            
            while (!stack.isEmpty()
                    && prices[stack.peek()] > prices[i]) {

                int index = stack.pop();
                answer[index] = i - index;
            }

            stack.push(i);
        }

        // 끝까지 가격이 떨어지지 않은 애들
        while (!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = prices.length - 1 - index;
        }

        return answer;
    }
}