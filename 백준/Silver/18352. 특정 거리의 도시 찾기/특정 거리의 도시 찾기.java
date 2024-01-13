

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int K;
    static int X;
    static ArrayList<Integer>[] arr;
    static int[] distance;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        X = sc.nextInt();
        arr = new ArrayList[N+1];
        distance = new int[N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < N + 1; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a].add(b);
        }
        bfs(X);
        boolean check = false;
        for (int i = 1; i < N + 1; i++) {
            if (distance[i] == K) {
                check = true;
                System.out.println(i);
            }
        }
        if (!check) {
            System.out.println(-1);
        }
    }
    private static void bfs(int a) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        visited[a] = true;
        while (!queue.isEmpty()) {
            int now = queue.remove();
            for (int next : arr[now]) {
                if (!visited[next]) {
                    distance[next] = distance[now] + 1;
                    visited[next] = true;
                    queue.add(next);
                }

            }
        }
    }
}
