import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (String s : operations) {
            String[] str = s.split(" ");
            int num = Integer.parseInt(str[1]);

            if (str[0].equals("I")) {
                map.put(num, map.getOrDefault(num, 0) + 1);

            } else if (str[0].equals("D")) {

                if (map.isEmpty()) {
                    continue;
                }

                int key;

                if (num == 1) {
                    key = map.lastKey();   // 최댓값
                } else {
                    key = map.firstKey();  // 최솟값
                }

                if (map.get(key) == 1) {
                    map.remove(key);
                } else {
                    map.put(key, map.get(key) - 1);
                }
            }
        }

        if (map.isEmpty()) {
            return new int[]{0, 0};
        }

        answer[0] = map.lastKey();
        answer[1] = map.firstKey();

        return answer;
    }
}
