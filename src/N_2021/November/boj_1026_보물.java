package N_2021.November;

import java.util.Arrays;
import java.util.Scanner;

public class boj_1026_보물 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] A = new int[N];
        int[] B = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int result = 0;

        for (int i = 0; i < N; i++) {
            result += A[i] * B[N-i-1];
        }

        System.out.println(result);



    }
}
