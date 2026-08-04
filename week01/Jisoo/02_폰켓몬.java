import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int N = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        
        if(N/2 < map.size()){
            return N/2;
        } 
        
        return map.size();
    }
}