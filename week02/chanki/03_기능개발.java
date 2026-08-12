import java.io.*;
import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        int idx = 0;
        int total = 0;
        while (idx < progresses.length) {
            int n = (int) Math.ceil((100 - progresses[idx]) / (double) speeds[idx]);
            int cnt = 0;
            for (int i=idx; i<progresses.length; ++i) {
                if (progresses[i] + speeds[i]*n >= 100) {
                    ++cnt;
                }
                else {
                    break;
                }
            }

            answer.add(cnt);
            idx += cnt;
        }



        return answer;
    }
}