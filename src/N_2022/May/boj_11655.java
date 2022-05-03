package N_2022.May;

import java.util.Scanner;

public class boj_11655 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if ('A' <= c[i] && c[i] <= 'Z') {
                if (c[i] + 13 > 'Z' - 0) {
                    c[i] = (char) (c[i] + 13 - 26);
                } else {
                    c[i] = (char) (c[i] + 13);
                }
            } else if ('a' <= c[i] && c[i] <= 'z') {
                if (c[i] + 13 > 'z' - 0) {
                    c[i] = (char) (c[i] + 13 - 26);
                } else {
                    c[i] = (char) (c[i] + 13);
                }
            }
        }
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i]);
        }
    }
}
