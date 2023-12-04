class Solution {
    public int solution(int[] common) {
        int A = common[1] - common[0];
        int B = common[2] - common[1];
        if (A != B) {
            return common[common.length-1] * (common[1] / common[0]);
        } else {
            return common[common.length-1] + (common[1] - common[0]);
        }
    }
}