package N_2022.April;

import java.util.Scanner;

public class boj_16953 {
    static int result = 0;
    static boolean check = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextInt();
        long B = sc.nextInt();
        recursive(A, B, 0);
        if (check) {
            System.out.println(result+1);
        } else {
            System.out.println(-1);
        }
    }

    private static void recursive(long A, long B, int cnt) {
        if (A > B) {
            return;
        }
        if (A == B) {
            check = true;
            result = cnt;
            return;
        }

        recursive(A * 2, B, cnt+1);
        recursive(Long.parseLong(A + "1"), B, cnt+1);
    }
}
