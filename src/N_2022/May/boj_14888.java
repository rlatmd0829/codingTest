package N_2022.May;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class boj_14888 {
    static int N;
    static int[] arr;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int plus = sc.nextInt();
        int minus = sc.nextInt();
        int mul = sc.nextInt();
        int div = sc.nextInt();
        recursive(arr[0], 0, plus, minus, mul, div);
        Collections.sort(list);
        System.out.println(list.get(list.size()-1));
        System.out.println(list.get(0));
    }
    public static void recursive(int start, int depth, int plus, int minus, int mul, int div) {
        if (depth == N-1) {
            list.add(start);
            return;
        }
        if (plus > 0) {
            recursive(start + arr[depth+1], depth+1, plus-1, minus, mul, div);
        }
        if (minus > 0) {
            recursive(start - arr[depth+1], depth+1, plus, minus-1, mul, div);
        }
        if (mul > 0) {
            recursive(start * arr[depth+1], depth+1, plus, minus, mul-1, div);
        }
        if (div > 0) {
            recursive(start / arr[depth+1], depth+1, plus, minus, mul, div-1);
        }
    }
}
