package N_2022.March;

public class pro_gb_1 {
    public static void main(String[] args) {
        System.out.println(solution(4, 3, 20, 4));
    }

    private static int solution(int mod1, int mod2, int max_range, int result) {
        int answer = 0;

        int gcd = getGCD(mod1, mod2);
        int lcm = mod1 * mod2 / gcd;

        int a = max_range / mod1;
        int b = max_range / lcm;

        return a-b;

//        for (int i = 1; i <= max_range; i++) {
//            if (i % mod1 == 0 && i % mod2 != 0) {
//                answer++;
//            }
//        }
//
//        return answer;
    }

    public static int getGCD(int mod1, int mod2) {
        if (mod1 % mod2 == 0) {
            return mod2;
        }
        return getGCD(mod2, mod1 % mod2);
    }
}
