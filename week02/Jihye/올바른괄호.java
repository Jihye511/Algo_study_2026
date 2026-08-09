import java.io.*;
import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Queue<Character> q = new LinkedList<>();
        char[] ch = new char[s.length()];
        for(int i =0; i<s.length(); i++){
            q.offer(s.charAt(i));
            if(i ==0 && s.charAt(i) == ')') return false;
        }
        int cnt=0;
        while(!q.isEmpty()){
            char cur = q.poll();
            if(cur =='(') cnt ++;
            else if(cur == ')') cnt--;
            
            if(cnt<0) return false;
            
        }
        if(cnt != 0) return false;

        return true;
    }
}
