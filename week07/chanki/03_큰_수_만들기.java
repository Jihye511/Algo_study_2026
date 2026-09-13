import java.io.*;
import java.util.*;

class Solution {

    public String solution(String number, int k) {
        String answer = "";

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<number.length(); ++i) {
            sb.append(number.charAt(i));
        }

        // System.out.println(sb.charAt(0));

        int cnt = 0;
        int idx = 0;
        while (cnt < k && idx < number.length()-1) {
            if (sb.charAt(idx) < sb.charAt(idx+1)) {
                sb.deleteCharAt(idx);
                if (idx != 0) {
                    --idx;
                }
                ++cnt;
            }
            else {
                ++idx;
            }
        }

        while (cnt < k) {
            sb.deleteCharAt(sb.length()-1);
            ++cnt;
        }

        answer = sb.toString();

        return answer;
    }
}