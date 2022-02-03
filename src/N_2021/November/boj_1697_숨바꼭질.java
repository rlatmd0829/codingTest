package N_2021.November;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_1697_숨바꼭질 {
    public static int N;
    public static int K;
    public static int[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        check = new int[100001];

        if (N == K) {
            System.out.println(0);
        } else {
            bfs();
        }

    }
    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        check[N] = 1;
        while (!queue.isEmpty()){
            int temp = queue.poll();

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) {
                    next = temp + 1;
                } else if (i == 1) {
                    next = temp - 1;
                } else {
                    next = temp * 2;
                }

                if (next == K) {
                    System.out.println(check[temp]);
                    return;
                }

                if (next >= 0 && next < check.length && check[next] == 0) {
                    queue.add(next);
                    check[next] = check[temp] + 1;
                }
            }
        }
    }
}
