import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int i =0; i<citations.length; i++){
            int n = citations[i];
            int idx = citations.length - i;
            
            if (n >= idx) {
                answer = Math.max(answer, idx);
            }
        }
        return answer;
    }
}
