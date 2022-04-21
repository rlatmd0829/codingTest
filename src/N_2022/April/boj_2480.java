package N_2022.April;

import java.util.Scanner;

public class boj_2480 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        arr[0] = sc.nextInt();
        arr[1] = sc.nextInt();
        arr[2] = sc.nextInt();

        if (arr[0] == arr[1] && arr[1] == arr[2]) {
            System.out.println(10000 + arr[0] * 1000);
        } else if (arr[0] == arr[1] || arr[0] == arr[2]) {
            System.out.println(1000 + arr[0] * 100);
        } else if (arr[1] == arr[2]) {
            System.out.println(1000 + arr[1] * 100);
        } else {
            int maxx = 0;
            for (int i = 0; i < 3; i++) {
                if (maxx < arr[i]) {
                    maxx = arr[i];
                }
            }
            System.out.println(maxx * 100);
        }

    }
}
