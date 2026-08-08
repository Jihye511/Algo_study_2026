import java.util.*;

public class Solution {
    public Stack<Integer> solution(int []arr) {
        Stack<Integer> q = new Stack<>();
        for(int i : arr){
            if(q.isEmpty()) q.add(i);
            if(q.peek() == i) continue;
            q.add(i);
        }
        return q;
    }
}
