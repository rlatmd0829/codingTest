class Solution {
    public int solution(String s) {
       int answer = 0;
        char[] c = s.toCharArray();
        char keyPoint = c[0];
        int same = 0;
        int notSame = 0;
        for (int i = 0; i < c.length; i++) {
            if (keyPoint == c[i]) {
                same++;
            } else {
                notSame++;
            }
            if (same == notSame || i == c.length-1) {
                same = 0;
                notSame = 0;
                if (i+1 < c.length) {
                    keyPoint = c[i+1];
                }
                answer++;
            }
        }
        return answer;
    }
}