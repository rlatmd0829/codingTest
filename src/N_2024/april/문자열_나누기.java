package N_2024.april;

public class 문자열_나누기 {
    public static void main(String[] args) {
        int result = solution("a");
        System.out.println(result);
    }

    public static int solution(String s) {
        int answer = 1;

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
            }
        }

        return answer;
    }
}
