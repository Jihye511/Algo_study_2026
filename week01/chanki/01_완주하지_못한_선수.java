import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> count = new HashMap<>();
        for (String p : participant) {
            count.put(p, count.getOrDefault(p, 0)+1);
        }

        for (String c : completion) {
            count.put(c, count.get(c)-1);
        }

        for (String k : count.keySet()) {
            if (count.get(k) <= 0) {
                continue;
            }
            answer = k;
        }

        return answer;
    }
}