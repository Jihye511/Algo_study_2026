import java.io.*;
import java.util.*;

class Solution {

    class Process {
        int idx;
        int priority;

        public Process() {}
        public Process(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        Queue<Process> q = new ArrayDeque<>();
        for (int i=0; i<priorities.length; ++i) {
            q.add(new Process(i, priorities[i]));
            pq.add(priorities[i]);
        }

        while (!q.isEmpty()) {
            Process curr = q.poll();
            if (curr.priority == pq.peek()) {
                pq.poll();
                ++answer;
                if (curr.idx == location) {
                    break;
                }
            }
            else {
                q.add(curr);
            }
        }


        return answer;
    }
}