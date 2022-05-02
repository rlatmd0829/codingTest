package N_2022.May;

import java.util.*;

public class boj_9237 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());

        int maxx = arr[0];
        for (int i = 0; i < arr.length; i++) {
            maxx -= 1;
            if (maxx < arr[i]) {
                maxx = arr[i];
            }
        }
        System.out.println(arr.length + maxx + 1);
    }
}
