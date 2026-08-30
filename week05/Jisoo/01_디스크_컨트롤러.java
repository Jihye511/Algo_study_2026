import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int n = jobs.length;

        // [작업번호, 요청시간, 소요시간]
        int[][] tasks = new int[n][3];

        for (int i = 0; i < n; i++) {
            tasks[i][0] = i;
            tasks[i][1] = jobs[i][0];
            tasks[i][2] = jobs[i][1];
        }
        
        Arrays.sort(tasks, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        // 소요시간 -> 요청시간 -> 작업번호 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[2] != b[2]) {
                return Integer.compare(a[2], b[2]);
            }

            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }

            return Integer.compare(a[0], b[0]);
        });

        int time = 0;       // 현재 시간
        int index = 0;      // 아직 대기큐에 안 넣은 작업 위치
        int completed = 0;  // 완료한 작업 개수
        int total = 0;      // 반환 시간의 총합

        while (completed < n) {

            
            while (index < n && tasks[index][1] <= time) {
                pq.offer(tasks[index]);
                index++;
            }

            
            if (!pq.isEmpty()) {
                int[] job = pq.poll();

                int requestTime = job[1];
                int duration = job[2];

                time += duration;

                // 종료 시간 - 요청 시간
                total += time - requestTime;

                completed++;
            } else {
                time = tasks[index][1];
            }
        }

        return total / n;
    }
}