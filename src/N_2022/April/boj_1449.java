package N_2022.April;

import java.util.Arrays;
import java.util.Scanner;

public class boj_1449 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int count = 0;
        int temp = L;
        boolean check = false;
        for (int i = 0; i < N; i++) {
            if (!check) {
                check = true;
                temp -= 1;
                count++;
                if (temp == 0) {
                    temp = L;
                    check = false;
                }
            } else {
                temp -= arr[i] - arr[i-1];
                if (temp < 0) {
                    temp = L-1;
                    count++;
                } else if (temp == 0) {
                    temp = L;
                    check = false;
                }
            }

        }
        System.out.println(count);
    }
}
