class Solution {
    public int solution(String name) {
        int answer = 0;
        int N = name.length();
        int move = N - 1;
        for(int i = 0; i < N; i++){
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            int idx = i + 1;
            while(idx < N && name.charAt(idx) == 'A') idx++;
            move = Math.min(move, i * 2 + N - idx);
            move = Math.min(move, i + (N - idx) * 2);
        }
        return answer + move;
    }
}
