import java.util.*;
class Solution {
    static int result, size;
    static int[] arr;
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] cloth : clothes){
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }
        size = map.size();
        arr = new int[size];
        int idx = 0;
        for(int i : map.values()){
            arr[idx] = i;
            idx++;
        }

        dfs(0, 1);
        return result - 1;
    }
    
    public static void dfs(int depth, int sum){
        if(depth == size){
            result += sum;
            return;
        }
        
        dfs(depth + 1, sum * arr[depth]);
        dfs(depth + 1, sum);
    }
}
