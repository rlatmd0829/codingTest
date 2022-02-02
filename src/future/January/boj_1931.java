package future.January;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class boj_1931 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt(); // 시작시간
            arr[i][1] = sc.nextInt(); // 끝난시간
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int start = 0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (start <= arr[i][0]) {
                count++;
                start = arr[i][1];
            }
        }

        System.out.println(count);
    }
}
