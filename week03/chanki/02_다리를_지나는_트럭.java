import java.util.*;

class Solution {

    class Truck {
        int w;
        int t;

        Truck(int w, int t) {
            this.w = w;
            this.t = t;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Truck> q = new ArrayDeque<>();
        int currW = 0;
        int currC = 0;
        int idx = 0;

        while (idx < truck_weights.length) {
            int size = q.size();
            for (int s = 0; s<size; ++s) {
                Truck curr = q.poll();
                --curr.t;
                if (curr.t == 0) {
                    currW -= curr.w;
                    --currC;
                }
                else {
                    q.offer(curr);
                }
            }

            if (currW + truck_weights[idx] <= weight && currC < bridge_length) {
                q.offer(new Truck(truck_weights[idx], bridge_length));
                currW += truck_weights[idx];
                ++currC;
                ++idx;
            }

            ++answer;
        }

        Truck lastOne = null;
        while (!q.isEmpty()) {
            lastOne = q.poll();
        }
        if (lastOne != null) {
            answer += lastOne.t;
        }

        return answer;
    }
}