package N_2022.April;

import java.util.Scanner;

public class boj_1193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int start = 1;
        boolean location = true; // true 분자가 큰 것, false 분모가 큰 것
        while (true) {
            if (X > start) {
                X -= start;
            } else {
                break;
            }
            start++;
            if (location) {
                location = false;
            }else {
                location = true;
            }
        }

        String[] arr = new String[start];
        int a = 1;
        int b = start;
        if (location) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = b + "/" + a;
                a += 1;
                b -= 1;
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = a + "/" + b;
                a += 1;
                b -= 1;
            }
        }
        System.out.println(arr[X-1]);

    }
}
