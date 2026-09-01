class Solution {
    public int solution(int[][] sizes) {
        int x_max = 0;
        int y_max = 0;
        
        for(int[] size : sizes){
            int max_size = Math.max(size[0], size[1]);
            int min_size = Math.min(size[0], size[1]);
            x_max = Math.max(x_max, max_size);
            y_max = Math.max(y_max, min_size);
        }
        
        return x_max * y_max;
    }
}
