import java.util.*;
class Solution {
    static int[] first = {1,2,3,4,5};
    static int[] second = {2,1,2,3,2,4,2,5};
    static int[] third = {3,3,1,1,2,2,4,4,5,5};
    static HashMap<Integer, Integer> map = new HashMap<>(Map.of(1, 0, 2, 0, 3, 0));
    public ArrayList<Integer> solution(int[] answers) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == first[i % 5]) map.put(1, map.get(1) + 1);
            if(answers[i] == second[i % 8]) map.put(2, map.get(2) + 1);
            if(answers[i] == third[i % 10]) map.put(3, map.get(3) + 1);
        }
        int max = Math.max(map.get(1), Math.max(map.get(2), map.get(3)));
        for(int i = 1; i < 4; i++){
            if(map.get(i) == max) result.add(i);
        }
        
        return result;
    }
}
