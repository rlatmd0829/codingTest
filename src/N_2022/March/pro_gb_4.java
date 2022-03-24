package N_2022.March;

import java.math.BigInteger;

public class pro_gb_4 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{5, 9, 1}, 1));
    }

    public static int solution(int[] estimates, int k) {
        int answer = 0;

        for (int i = 0; i < k; i++) {
            answer += estimates[i];
        }

        int ans = answer;

        for (int i = k; i < estimates.length; i++) {
            ans = Math.max(answer - estimates[i-k] + estimates[i], ans);
            answer = answer - estimates[i-k] + estimates[i];
        }

        return Math.max(ans, answer);
    }
}
