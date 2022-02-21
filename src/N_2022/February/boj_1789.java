package N_2022.February;

import java.util.Scanner;

public class boj_1789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long S = sc.nextLong();
        long N = 0;
        long i = 1;
        long count = 0;
        while (N <= S) {
            N += i;
            i++;
            count++;
        }
        System.out.println(count - 1);
    }
}
