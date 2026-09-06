import java.util.*;
class Solution {
    ArrayList<String> word_list = new ArrayList<>();
    String[] alpha = new String[] {"A", "E", "I", "O", "U"};
    public int solution(String word) {
        dfs(0, "");
        int answer = word_list.indexOf(word) + 1;
        return answer;
    }
    
    public void dfs(int idx, String str){
        if(idx == 5) return;
        
        for(int i = 0; i < 5; i++){
            word_list.add(str + alpha[i]);
            dfs(idx + 1, str + alpha[i]);
        }
    }
}
