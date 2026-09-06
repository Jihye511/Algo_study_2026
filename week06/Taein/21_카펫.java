class Solution {
    public int[] solution(int brown, int yellow) {
        for(int i = yellow; i > 0; i--){
            if(yellow % i != 0) continue;
            int row = i;
            int col = yellow / row;
            if((row + 2) * 2 + col * 2 == brown) return new int[] {row + 2, col + 2};
        }
        return null;
    }
}
