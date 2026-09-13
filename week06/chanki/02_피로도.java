import java.util.*;
import java.io.*;
/*
- 최소 필요 피로도(던전 시작을 위한) / 소모 피로도(던전 탐험 끝날 때)
- 최대한 많이 탐험 -> 현재 피로도 k / [최소][소모]
*/


class Solution {

    int max = Integer.MIN_VALUE;
    boolean[] v;

    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        v = new boolean[dungeons.length];
        recursive(dungeons, 0, k);
        answer = max;

        return answer;
    }

    public void recursive(int[][] dungeons, int idx, int stamina) {
        for (int i=0; i<dungeons.length; ++i) {
            if (!v[i] && stamina >= dungeons[i][0]) {
                v[i] = true;
                recursive(dungeons, idx+1, stamina-dungeons[i][1]);
                v[i] = false;
            }
        }

        max = Math.max(max, idx);
    }
}