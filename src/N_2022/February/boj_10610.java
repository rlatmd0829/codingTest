package N_2022.February;

import java.util.Arrays;
import java.util.Scanner;

public class boj_10610 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        char[] c = N.toCharArray();
        int sum = 0;

        for (int i = 0; i < c.length; i++) {
            sum += c[i] - '0';
        }

        Arrays.sort(c);
        if (c[0] == '0' && sum % 3 == 0) { // 30의 배수가 맞으면 : 30을 소인수 분해하면 2,3,5가 나온다
            for (int i = c.length-1; i >= 0; i--) { // 2 * 5로 무조건 맨마지막은 0이여야하고 3으로 모든 자릿수 더한 값이 3으로 나눠져야한다.
                System.out.print(c[i]);
            }
        } else {
            System.out.println(-1);
        }

    }

}
