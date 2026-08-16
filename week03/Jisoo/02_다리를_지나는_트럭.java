import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();

        
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        int time = 0;
        int currentWeight = 0;
        int truckIndex = 0;

        while (truckIndex < truck_weights.length) {
            // 1초 경과
            time++;

            // 다리 맨 앞의 트럭이 빠져나감
            currentWeight -= bridge.poll();

            // 다음 트럭을 올릴 수 있는지 확인
            if (currentWeight + truck_weights[truckIndex] <= weight) {
                bridge.offer(truck_weights[truckIndex]);
                currentWeight += truck_weights[truckIndex];
                truckIndex++;
            } else {
                // 못 올라가면 빈 공간
                bridge.offer(0);
            }
        }

        // 마지막 트럭이 올라간 뒤 다리를 완전히 빠져나가는 시간
        return time + bridge_length;
    }
}