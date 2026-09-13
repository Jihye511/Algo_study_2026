import java.io.*;
import java.util.*;

/*
가로 >= 세로
y가 홀수면 무조건 한 줄?
짝수면 2줄 3줄 4줄
*/

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int cnt = 0;
        for (int i=1; i<=Math.sqrt(yellow); ++i) {
            if (yellow % i == 0) {
                int tmp = yellow / i; // i는 세로, tmp는 가로
                int b = 2*tmp + 2*i + 4;
                if (brown == b) {
                    answer[0] = tmp+2;
                    answer[1] = i+2;
                    break;
                }
            }
        }


        return answer;
    }
}