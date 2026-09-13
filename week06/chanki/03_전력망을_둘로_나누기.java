import java.io.*;
import java.util.*;

class Solution {

    int[] parent, count;

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;;

        boolean[] check = new boolean[wires.length];
        for (int i=0; i<check.length; ++i) {
            check[i] = true;


            parent = new int[n];
            count = new int[n];

            init();

            for (int j=0; j<check.length; ++j) {
                if (!check[j]) {
                    union(wires[j][0]-1, wires[j][1]-1);
                }
            }

            int p1 = find(0);
            int p2 = 0;
            for (int j=1; j<n; ++j) {
                p2 = find(j);
                if (p1 != p2) {
                    break;
                }
            }

            int gap = Math.abs(count[p1]-count[p2]);

            answer = Math.min(answer, gap);

            check[i] = false;
        }

        return answer;
    }

    public void init() {
        for (int i=0; i<parent.length; ++i) {
            parent[i] = i;
            count[i] = 1;
        }
    }

    public void union(int a, int b) {

        int pa = find(a);
        int pb = find(b);

        if (pa == pb) {
            return;
        }

        if (pa <= pb) {
            parent[pb] = pa;
            count[pa] += count[pb];
        }
        else {
            parent[pa] = pb;
            count[pb] += count[pa];
        }
    }

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }
}