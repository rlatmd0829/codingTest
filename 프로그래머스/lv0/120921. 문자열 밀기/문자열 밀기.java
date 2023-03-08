class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        if (A.equals(B)) {
            return 0;
        }
        for (int i = 1; i < A.length(); i++) {
            answer++;
            String temp = A.substring(A.length() - i, A.length()) + A.substring(0, A.length() - i);
            if (B.equals(temp)) {
                return answer;
            }
        }
        return -1;
    }
}