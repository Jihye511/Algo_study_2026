import java.io.*;
import java.util.*;


public class Solution {
    public List<Integer> solution(int []arr) {
        List<Integer> answer = new ArrayList<>();

        int prev = -1;
        for (int a : arr) {
            if (a != prev) {
                answer.add(a);
            }
            prev = a;
        }


        return answer;
    }
}