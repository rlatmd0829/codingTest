package N_2022.February;

import java.util.Scanner;

public class boj_10162 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int a1 = 300;
        int a2 = 60;
        int a3 = 10;

        int count1 = 0;
        int count2 = 0;
        int count3 = 0;

        boolean check = false;

        while (T > 0) {
            if (T >= a1) {
                T -= a1;
                count1++;
            } else if (T >= a2) {
                T -= a2;
                count2++;
            } else if (T >= a3) {
                T -= a3;
                count3++;
            } else {
                check = true;
                break;
            }
        }

        if (check) {
            System.out.println(-1);
        } else {
            System.out.println(count1 + " " + count2 + " " + count3);
        }
    }
}
