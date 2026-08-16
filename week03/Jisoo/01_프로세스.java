import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<priorities.length; i++){
            list.add(priorities[i]);
        }
        Collections.sort(list);
        
        Queue<int[]> queue = new ArrayDeque<>();
        
        // queue에 [위치, 우선순위] 저장
        for(int i=0; i<priorities.length; i++){
            queue.offer(new int[]{i,priorities[i]});
        }
        
        int maxNum = list.removeLast();
        int cnt = 0;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int loc = now[0];
            int num = now[1];
            if(num == maxNum){
                if(loc == location) {
                    cnt++;
                    return cnt++;
                } else {
                    cnt++;
                    maxNum = list.removeLast();
                }
            } else {
                queue.offer(new int[] {loc,num});
            }
        }
        
        return answer;
    }
}