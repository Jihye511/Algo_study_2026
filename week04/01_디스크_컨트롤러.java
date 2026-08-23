import java.io.*;
import java.util.*;

/*
- 작업 번호는 idx
- 반환시간 = (작업 종료 시각 - 작업 요청 시각)
*/

class Solution {

    class Job implements Comparable<Job> {
        int idx;
        int time;
        int length;

        Job(int idx, int time, int length) {
            this.idx = idx;
            this.time = time;
            this.length = length;
        }

        @Override
        public int compareTo(Job o) {
            if (this.length == o.length) {
                if (this.time == o.time) {
                    return Integer.compare(this.idx, o.idx);
                }

                return Integer.compare(this.time, o.time);
            }

            return Integer.compare(this.length, o.length);
        }
    }

    public int solution(int[][] jobs) {
        int answer = 0;

        Queue<Job> pq = new PriorityQueue<>();

        int idx = 0;
        int total = 0;
        int currTime = 0;

        Job[] sortedJobs = new Job[jobs.length];
        for (int i=0; i<jobs.length; ++i) {
            sortedJobs[i] = new Job(i, jobs[i][0], jobs[i][1]);
        }

        Arrays.sort(sortedJobs, (o1, o2) -> (Integer.compare(o1.time, o2.time)));

        while (idx < jobs.length || !pq.isEmpty()) {
            int cnt = 0;

            for (int i=idx; i<jobs.length; ++i) {
                if (sortedJobs[i].time > currTime) {
                    if (i == idx && pq.isEmpty()) {
                        currTime = sortedJobs[i].time;
                    }
                    break;
                }
                ++cnt;
                pq.add(sortedJobs[i]);
            }

            if (cnt == 0 && pq.isEmpty()) {
                continue;
            }


            idx += cnt;

            Job curr = pq.poll();
            total += ((currTime + curr.length - curr.time));
            currTime += curr.length;
            System.out.println(currTime);
        }

        answer = (total / jobs.length);

        return answer;
    }
}