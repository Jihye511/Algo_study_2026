import java.util.*;
class Solution {
    static ArrayList<Integer>[] adj;
    static int N, result = Integer.MAX_VALUE;
    public int solution(int n, int[][] wires) {
        N = n;
        adj = new ArrayList[n+1];
        for(int i = 0; i <= n; i++) adj[i] = new ArrayList<>();
        for(int[] wire : wires){
            adj[wire[0]].add(wire[1]);
            adj[wire[1]].add(wire[0]);
        }
        
        for(int[] wire : wires) check(wire[0], wire[1]);
        
        return result;
    }
    
    public void check(int a, int b){
        boolean[] visited = new boolean[N+1];
        visited[a] = true;
        visited[b] = true;
        int cnt1 = count(a, visited);
        int cnt2 = count(b, visited);
        result = Math.min(result, Math.abs(cnt1 - cnt2));
    }
    
    public int count(int start, boolean[] visited){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        int cnt = 0;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i : adj[now]){
                if(!visited[i]){
                    visited[i] = true;
                    q.add(i);
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}
