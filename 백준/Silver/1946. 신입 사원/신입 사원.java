

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(bf.readLine());
            int[][] arr = new int[N][2];
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                arr[j][0] = Integer.parseInt(st.nextToken());
                arr[j][1] = Integer.parseInt(st.nextToken());
            }
            int count = 1;
            Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
            int minn = arr[0][1];
            for (int j = 1; j < N; j++) {
                if (minn > arr[j][1]) {
                    minn = arr[j][1];
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
