import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] clothes = new int[n+1];
        Arrays.fill(clothes, 1);
        for(int now : reserve) clothes[now] = 2;
        for(int now : lost) {
            if(clothes[now] > 1) clothes[now] = 1;
            else clothes[now] = 0;
        }
        
        Arrays.sort(lost);
        
        for(int now : lost){
            if(clothes[now] == 1) continue;
            for(int i = now - 1; i <= now + 1; i += 2){
                if(i < 1 || i > n) continue;
                if(clothes[i] == 2){
                    clothes[i] = 1;
                    clothes[now] = 1;
                    break;
                }
            }
        }
        
        int answer = 0;
        for(int i = 1; i <= n; i++) if(clothes[i] > 0) answer++;
        
        return answer;
    }
}
