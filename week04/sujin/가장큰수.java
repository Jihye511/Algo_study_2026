import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        int n = numbers.length;
        Integer[] newNums = new Integer[n];
        
        for (int i = 0; i < n; i++) {
            newNums[i] = numbers[i];  
        }
        
        Arrays.sort(newNums, (a, b) -> {  
            String newA = String.valueOf(a);
            String newB = String.valueOf(b);
            
            return (newB + newA).compareTo(newA + newB);  
        });
        StringBuilder sb = new StringBuilder();

        for (int nn: newNums) {  
            sb.append(nn);  
        }
        
        if (sb.charAt(0) == '0') {   
            return "0";
        }
        
        return sb.toString();
    }
}