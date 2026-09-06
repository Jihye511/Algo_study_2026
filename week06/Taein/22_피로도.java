class Solution {
    static int N, result = 0;
    public int solution(int k, int[][] dungeons) {
        N = dungeons.length;
        dfs(0, k, new boolean[N], dungeons);
        return result;
    }
    
    public void dfs(int cnt, int now_k, boolean[] visited, int[][] dungeons){
        if(result < cnt) result = cnt;
        
        for(int i = 0; i < N; i++){
            if(!visited[i] && now_k >= dungeons[i][0]){
                visited[i] = true;
                dfs(cnt + 1, now_k - dungeons[i][1], visited, dungeons);
                visited[i] = false;
            }
        }
    }
}
