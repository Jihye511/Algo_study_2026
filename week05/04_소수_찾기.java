import java.io.*;
import java.util.*;

class Solution {

    Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;

        for (int i=1; i<=numbers.length(); ++i) {
            recur(numbers, new boolean[numbers.length()], 0, new StringBuilder(), i);
        }

        System.out.println(set);

        return set.size();
    }

    public void recur(String numbers, boolean[] used, int cnt, StringBuilder sb, int r) {
        if (cnt == r) {

            if (sb.length() != 0) {
                int n = Integer.parseInt(sb.toString());
                if (isPrime(n)) {
                    set.add(n);
                }

            }

            return;
        }

        for (int i=0; i<numbers.length(); ++i) {
            if (!used[i]) {
                used[i] = true;
                sb.append(numbers.charAt(i));
                recur(numbers, used, cnt+1, sb, r);
                used[i] = false;
                sb.delete(sb.length()-1, sb.length());
            }
        }
    }

    public boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        int cnt = 0;

        for (int i=2; i<=Math.sqrt(num); ++i) {
            if (num % i == 0) {
                ++cnt;
            }
        }

        return cnt == 0;
    }
}