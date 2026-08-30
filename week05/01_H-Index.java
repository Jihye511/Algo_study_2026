import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);
        for (int i=citations.length-1; i>=0; --i) {
            // length - i는 h번 이상 인용된 논문 수
            // citations[i] = h
            if (citations.length - i <= citations[i]) {
                answer = citations.length - i;
            }
            else {
                break;
            }
        }

        return answer;
    }
}