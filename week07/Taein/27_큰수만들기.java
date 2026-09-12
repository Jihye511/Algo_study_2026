import java.util.*;
class Solution {
    public StringBuilder solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();
        int N = number.length();
        for(int i = 0; i < N; i++){
            int now = (number.charAt(i) - '0');
            if(!stack.isEmpty()){
                if(k > 0){
                    while(!stack.isEmpty()){
                        if(k <= 0) break;
                        if(stack.peek() < now){
                            k--;
                            stack.pop();    
                        }
                        else{
                            break;
                        }
                    }
                }
            }
            stack.add(now);
        }
        for(int i = k; i > 0; i--) stack.pop();
        
        StringBuilder sb = new StringBuilder();
        for(int i : stack) sb.append(i);
        return sb;
    }
}
