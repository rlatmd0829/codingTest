package N_2022.February;

import java.util.Scanner;

public class boj_4796 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int count = 1;
        while (true) {
            int L = sc.nextInt();
            if (L == 0) {
                break;
            }
            int P = sc.nextInt();
            int V = sc.nextInt();

            int div = V / P;

            int remain = Math.min(V % P, L);

            int result = L * div + remain;

            System.out.printf("Case %d: %d", count, result);
            System.out.println();
            count++;
        }
    }
}
