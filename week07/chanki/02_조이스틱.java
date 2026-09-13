import java.io.*;
import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int n = name.length();
        int move = n - 1;

        for (int i = 0; i < n; i++) {
            int diff = name.charAt(i) - 'A';
            answer += Math.min(diff, 26 - diff);

            int next = i + 1;
            while (next < n && name.charAt(next) == 'A') {
                next++;
            }

            move = Math.min(move, i * 2 + (n - next));

            move = Math.min(move, (n - next) * 2 + i);
        }

        return answer + move;
    }
}