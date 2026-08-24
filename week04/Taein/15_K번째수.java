import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] array, int[][] commands) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int[] command : commands){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = command[0] - 1; i < command[1]; i++) temp.add(array[i]);
            Collections.sort(temp);
            answer.add(temp.get(command[2] - 1));
        }
        return answer;
    }
}
