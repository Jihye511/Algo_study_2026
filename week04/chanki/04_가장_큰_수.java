import java.io.*;
import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        Queue<String> pq = new PriorityQueue<>((o1, o2) -> {
            return (o2+o1).compareTo(o1+o2);
        });

        for (int i=0; i<numbers.length; ++i) {
            String s = String.valueOf(numbers[i]);
            pq.add(s);
        }

        if (pq.peek().charAt(0) == '0') {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll());
        }

        answer = sb.toString();

        return answer;
    }
}