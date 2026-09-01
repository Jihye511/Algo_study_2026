import java.util.*;
class Solution {
    static int N;
    static Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        N = numbers.length();
        char[] arr = numbers.toCharArray();
        dfs(arr, new boolean[N], 0, 0);
        int result = 0;
        for(int i : set){
            if(check(i)) result++;
        }
        
        System.out.println(set.toString());
        
        return result;
    }
    
    public void dfs(char[] arr, boolean[] visited, int depth, int num){
        set.add(num);
        
        for(int i = 0; i < N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            dfs(arr, visited, depth + 1, num * 10 + (arr[i] - '0'));
            visited[i] = false;
        }
        
    }

    public boolean check(int num){
        if(num < 2) return false;
        int cnt = 0;
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}
