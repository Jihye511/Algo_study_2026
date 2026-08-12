import java.util.*;
class Solution {
    boolean solution(String s) {
        Deque<String> stack = new ArrayDeque<>();
        
        
        for (int i=1; i<s.length(); i++){
            String str = s.substring(i,i+1);
            if(stack.size()==0){
                stack.push(str);
            }
            else if(str.equals(")") && stack.peek().equals("(")){
                stack.poll();
            } else {
                stack.push(str);
            }
        }

        if(stack.size()==0){
            return true;
        }
        return false;
        
    }
}