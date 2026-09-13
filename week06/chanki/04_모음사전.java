import java.io.*;
import java.util.*;

/*
1 A
2 A A
3 A A A

4 A A A A
5 A A A A A
6 A A A A E
7 A A A A I
8 A A A A O
9 A A A A U

10 A A A E
11 A A A E A
12 A A A E E
13 A A A E I
14 A A A E O
15 A A A E U

16 A A A I
17 A A A I A
18 A A A I E
19 A A A I I
20 A A A I O
21 A A A I U


AAAA는 3 + 5 0 + 1 = 4
AAAE는 3 + 5 * 1 + 2 = 10
AAAI는 3 + 5 * 2 + 3 = 16

AAAAA는 AAAA + (AEIOU 인덱스+1)

AAAA는 AAA + (AEIOU인덱스+1)
AAA는 (길이-1) + 6*0(마지막문자의인덱스) + 1(마지막문자의인덱스+1)

A = (1-1) + 156*5*0 + 1
I = (1-1) + 156*5*2 + 3

EIO = E + AI + AAO
E = (1-1) + 156*5*1 + 2 = 782
AI = (2-1) + 31*5*2 + 3 = 314
AAO = (3-1) + 6*5*3 + 4 = 96


AA = A + AA
A =  156*5*0 + 1 = 1
AA =  31*5*0 + 1 = 2
AAA =6*5*0 + 1 = 3
6 - 3

AAAAE = 4 + 0 + 2

AAAE는 3 + 1 + 5*1개 다음 (x, A~U)
AAA 에 대해서 1 + 5 * 6 *(인덱스)개 (x + A~U * AAAA에 대한 개수)
AA 에 대해서 1 + 5 * 31개
A에 대해서 1 + 5 * 156개

*/


class Solution {

    String[] strings = {"A", "E", "I", "O", "U"};
    int[] mul = {156*5, 31*5, 6*5, 1*5, 0};
    Map<String, Integer> map = new HashMap<>();

    public int solution(String word) {
        int answer = 0;

        map.put("A", 0);
        map.put("E", 1);
        map.put("I", 2);
        map.put("O", 3);
        map.put("U", 4);


        for (int l=0; l<word.length(); ++l) {
            String end = word.substring(l, l+1);
            int idx = map.get(end);
            answer += mul[l] * idx + (idx+1);
        }


        return answer;
    }
}