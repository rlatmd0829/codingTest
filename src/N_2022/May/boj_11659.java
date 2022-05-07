package N_2022.May;

import java.util.Scanner;

public class boj_11659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        int[] sum = new int[N+1];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 1; i < N+1; i++) {
            sum[i] = arr[i-1] + sum[i-1];
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(sum[b] - sum[a-1]);
        }
    }
}
