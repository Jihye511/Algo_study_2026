import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Arrays.sort(lost);

        boolean[] used = new boolean[n+1];
        boolean[] possible = new boolean[n+1];
        Arrays.fill(used, true);
        Arrays.fill(possible, true);
        for (int i=0; i<reserve.length; ++i) {
            used[reserve[i]] = false;
        }

        for (int i=0; i<lost.length; ++i) {
            possible[lost[i]] = false;
            for (int j=0; j<reserve.length; ++j) {
                if (lost[i] == reserve[j]) {
                    used[reserve[j]] = true;
                    possible[lost[i]] = true;
                    ++answer;
                }
            }
        }


        for (int i=0; i<lost.length; ++i) {
            int curr = lost[i];

            if (possible[curr]) {
                continue;
            }

            if (curr == 1) {
                if (!used[curr+1]) {
                    ++answer;
                    used[curr+1] = true;
                }
            }
            else if (curr == n) {
                if (!used[curr-1]) {
                    ++answer;
                    used[curr-1] = true;
                }
            }
            else {
                if (!used[curr-1]) {
                    ++answer;
                    used[curr-1] = true;
                }
                else if (!used[curr+1]) {
                    ++answer;
                    used[curr+1] = true;
                }
            }
        }


        return answer;
    }
}