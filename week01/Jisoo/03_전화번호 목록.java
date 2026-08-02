import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>();
        for(String str : phone_book){
            set.add(str);
        }
        for(String str : phone_book){
            for(int i=1; i<str.length(); i++){
                String phone = str.substring(0,i);
                if(set.contains(phone)){
                    return false;
                }
            }
        }
        
        return true;
    }
}