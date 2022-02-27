package N_2022.February;

import java.util.Arrays;
import java.util.Scanner;

public class boj_1049 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int a = N / 6;
        int b = N % 6;
        int min = Integer.MAX_VALUE;

        int[] P = new int[M];
        int[] EA = new int[M];

        for (int i = 0; i < M; i++) {
            P[i] = sc.nextInt();
            EA[i] = sc.nextInt();
        }
        Arrays.sort(P);
        Arrays.sort(EA);

        if (P[0] < EA[0] * b) {
            min = Math.min(min, a * P[0] + P[0]);
        } else {
            min = Math.min(min, a * P[0] + EA[0] * b);
        }
        min = Math.min(min, P[0] * (a+1));
        System.out.println(Math.min(min, EA[0] * N));
    }
}
