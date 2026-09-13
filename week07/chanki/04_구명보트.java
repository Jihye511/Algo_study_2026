import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        boolean[] end = new boolean[people.length];

//         int idx = 0;
//         for (idx = people.length-1; idx >= 0; --idx) {
//             if (people[0] + people[idx] <= limit) {
//                 break;
//             }
//         }

        int l = 0;
        int r = people.length-1;
        while (l <= r) {
            if (people[l] + people[r] > limit) {
                ++answer;
                --r;
            }
            else {
                ++answer;
                ++l;
                --r;
            }
        }

        return answer;
    }
}