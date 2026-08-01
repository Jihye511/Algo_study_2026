import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for(int i = 0; i < phone_book.length - 1; i++){
            if(check(phone_book[i], phone_book[i + 1])) return false;
        }
        return true;
    }
    
    public static boolean check(String s1, String s2){
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }
}
