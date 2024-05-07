

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        char[] temp = s.toCharArray();
        int count0 = 0; // 1이였다가 0으로 바뀜
        int count1 = 0;
        char test = '1';
        boolean check = false;

        for (int i = 0; i < temp.length; i++) {
            if (check) {
                if (temp[i] == '0') {
                    continue;
                } else {
                    check = false;
                }
            }

            if (temp[i] == '0') {
                count0++;
                check = true;
            }
        }

        check = false;

        for (int i = 0; i < temp.length; i++) {
            if (check) {
                if (temp[i] == '1') {
                    continue;
                } else {
                    check = false;
                }
            }

            if (temp[i] == '1') {
                count1++;
                check = true;
            }
        }

        System.out.println(Math.min(count0, count1));
    }
}
