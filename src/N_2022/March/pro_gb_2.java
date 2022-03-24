package N_2022.March;

public class pro_gb_2 {
    public static void main(String[] args) {
        System.out.println(solution("<<<><"));
    }

    private static int solution(String P) {
        int answer = 0;

        char[] c = P.toCharArray();
        int left = 0;
        int right = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '<') {
                if (left-i == 0) {
                    answer++;
                }
                left++;
            } else {
                break;
            }
        }

        for (int i = c.length-1; i >= 0 ; i--) {
            if (c[i] == '>') {
                if (c.length-1 - i - right == 0) {
                    answer++;
                }
                right++;
            } else {
                break;
            }
        }

        return answer;
    }
}
