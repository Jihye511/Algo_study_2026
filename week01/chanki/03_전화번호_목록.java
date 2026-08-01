import java.io.*;
import java.util.*;

class Solution {

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Map<String, Integer> map = new HashMap<>();

        for (String s : phone_book) {
            map.put(s, 1);
        }

        L: for (String s : phone_book) {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<s.length()-1; ++i) {
                sb.append(s.charAt(i));

                if (map.containsKey(sb.toString())) {
                    answer = false;
                    break L;
                }
            }
        }

        return answer;
    }
}