package N_2022.May;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_16928_2 {
    static int N;
    static int M;
    static int[] arr;
    static boolean[] visited;
    static int[] distance;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[101];
        visited = new boolean[101];
        distance = new int[101];
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[x] = y;
        }
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            arr[u] = v;
        }
        bfs();
        System.out.println(distance[100]);
    }
    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            Integer now = queue.remove();

            if (now > 100) {
                continue;
            }
            if (distance[100] != 0) {
                return;
            }

            for (int i = 1; i <= 6; i++) {
                if (now + i <= 100) {
                    if (arr[now + i] != 0) {
                        if (!visited[arr[now + i]]) {
                            visited[arr[now + i]] = true;
                            distance[arr[now + i]] = distance[now] + 1;
                            queue.add(arr[now + i]);
                        }
                        // 사다리가 있는데 이미 방문했을 경우에도 else if 를 타면 안된다.
                    } else if (!visited[now + i]){
                        visited[now + i] = true;
                        distance[now + i] = distance[now] + 1;
                        queue.add(now + i);
                    }
                }
            }
        }
    }
}
