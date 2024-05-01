class Solution {
    public int solution(String s) {
        int answer = 0;
        
        if (s.length() == 1) {
            return 1;
        }

        char[] chars = s.toCharArray();
        char key = chars[0];
        int count1 = 1;
        int count2 = 0;

        for (int i = 1; i < chars.length; i++) {
            if (key == chars[i]) {
                count1++;
            } else {
                count2++;
            }

            if (count1 == count2) {
                answer++;
                count1 = 0;
                count2 = 0;
                if (i + 1 < chars.length) {
                    key = chars[i + 1];
                }
            } else {
                if (i == chars.length - 1) {
                    answer++;
                }
            }
        }

        return answer;
    }
}