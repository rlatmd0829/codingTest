class Solution {
    public int solution(int[][] sizes) {
        int fnlMax = 0;
        int fnlMin = 0;
        for (int i = 0; i < sizes.length; i++) {
            int max = Math.max(sizes[i][0], sizes[i][1]);
            int min = Math.min(sizes[i][0], sizes[i][1]);
            
            fnlMax = Math.max(fnlMax, max);
            fnlMin = Math.max(fnlMin, min);
        }
        return fnlMax * fnlMin;
    }
}