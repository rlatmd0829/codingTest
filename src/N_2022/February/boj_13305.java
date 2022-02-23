package N_2022.February;

import java.util.Scanner;

public class boj_13305 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] distance = new int[N-1];
        int[] cost = new int[N];

        for (int i = 0; i < N - 1; i++) {
            distance[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            cost[i] = sc.nextInt();
        }
        long sum = 0;
        for (int i = 1; i < N; i++) {
            if (cost[i-1] < cost[i]) {
                cost[i] = cost[i-1];
            }
            sum += (long) cost[i - 1] * distance[i-1];
        }
        System.out.println(sum);
    }
}
