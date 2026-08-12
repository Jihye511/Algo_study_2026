import java.util.*;
import java.io.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        Stack<Integer> stack = new Stack<>();
        for(int a : arr){
            if(stack.isEmpty()){
                stack.push(a);
            }else{
                if(stack.peek() !=a){
                    stack.push(a);
                }
            }
            
        }
        ArrayList<Integer> list = new ArrayList<>();
        //pop은 역순으로 나와서 reverse 필요하지만 아래 for문은 그저 순회문
        //(Stack의 맨 아래부터 맨 위까지 순회)
        for(int s : stack){
            list.add(s);
        }
        // Collections.reverse(list);
        answer = new int[list.size()];
        for(int i =0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
