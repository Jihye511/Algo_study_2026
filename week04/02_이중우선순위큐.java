import java.io.*;
import java.util.*;

/*
맥스힙이랑 민힙이랑 동시 사용해서 동기화 어떻게 해야 되나 몰라서 GPT 참고
-> 근데 그냥 pq.remove(n) 하면 순서 상관없이 n에 해당하는 값 삭제 됨
*/

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (String operation : operations) {
            String[] oper = operation.split(" ");
            solve (map, oper[0], Integer.parseInt(oper[1]));
        }

        if (!map.isEmpty()) {
            answer[1] = map.firstKey();
            answer[0] = map.lastKey();
        }

        return answer;
    }

    public void solve(TreeMap<Integer, Integer> map, String oper, int num) {
        if (oper.equals("I")) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        else if (!map.isEmpty()) {
            int key = 0;
            if (num > 0) {
                key = map.lastKey();
            }
            else {
                key = map.firstKey();
            }

            if (map.containsKey(key)){
                map.put(key, map.get(key)-1);
                if (map.get(key) == 0) {
                    map.remove(key);
                }
            }
        }
    }
}