package N_2022.May;

import java.util.Arrays;
import java.util.Scanner;

public class boj_2559 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        int sum = 0;
        int maxx = Integer.MIN_VALUE;
        for (int i = 0; i < K; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        if (sum > maxx) {
            maxx = sum;
        }
        for (int i = 0; i < N - K; i++) {
            sum -= arr[i];
            arr[i+K] = sc.nextInt();
            sum += arr[i+K];
            if (sum > maxx) {
                maxx = sum;
            }
        }
        System.out.println(maxx);
    }
}
