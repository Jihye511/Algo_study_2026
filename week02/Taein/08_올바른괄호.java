import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == ')'){
                if(stack.isEmpty()) return false;
                if(stack.peek() == '(') stack.pop();
            }
            else{
                stack.add(c);
            }
                
        }

        if(stack.size() > 0) return false;
        return true;
    }
}
