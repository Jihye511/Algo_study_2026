import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;

        int first = 0;
        int second = 0;
        if (sizes[0][0] < sizes[0][1]) {
            first = sizes[0][1];
            second = sizes[0][0];
        }

        for (int i=0; i<sizes.length; ++i) {
            if (sizes[i][0] > sizes[i][1]) {
                first = Math.max(first, sizes[i][0]);
                second = Math.max(second, sizes[i][1]);
            }
            else {
                first = Math.max(first, sizes[i][1]);
                second = Math.max(second, sizes[i][0]);
            }
        }



        return first * second;
    }
}