import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        int N = numbers.length;
        String[] str = new String[N];
        for(int i = 0; i < N; i++) str[i] = Integer.toString(numbers[i]);
        Arrays.sort(str, (a1, a2) -> (a2 + a1).compareTo(a1 + a2));
        return str[0].equals("0") ? "0" : String.join("", str);
    }
}
