package N_2022.February;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class boj_2217 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());

        int maxx = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = arr[i] * (i+1);
            if (maxx < arr[i]) {
                maxx = arr[i];
            }
        }

        System.out.println(maxx);
    }
}
