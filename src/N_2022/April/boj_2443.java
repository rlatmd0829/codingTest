package N_2022.April;

import java.util.Scanner;

public class boj_2443 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int k = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * N - k; j++) {
                System.out.print("*");
            }
            k += 2;
            System.out.println();
        }
    }
}
