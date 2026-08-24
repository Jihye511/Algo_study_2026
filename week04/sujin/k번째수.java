import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        // i: i번쨰 숫자부터 j 번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수
        for (int idx = 0; idx < commands.length; idx++) {
            int[] com = commands[idx];
            int i = com[0] - 1;
            int j = com[1] - 1;
            int k = com[2] - 1;
            
            int [] newArr = new int[j - i + 1];
            
            for (int m = i; m <= j; m++) {
                newArr[m-i] = array[m];
            }
            
            Arrays.sort(newArr);
            answer[idx] = newArr[k];
                
        }
        return answer;
    }
}