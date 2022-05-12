// 재귀 풀이 스택오버플로우 에러남
// bfs로 푸는게 맞는듯
package N_2022.May;

import java.util.Scanner;

public class boj_16928 {
    static int N;
    static int M;
    static int[] arr;
    static boolean[] visited;
    static int[] value;
    static int minn = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[101];
        visited = new boolean[101];
        value = new int[101];
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
        recursive(1, 0, 0);
        System.out.println(minn);
        System.out.println(value[100]);
    }
    public static void recursive(int now, int next, int count) {
        if (now + next > 100 || count > 10) {
            return;
        }
        if (now + next == 100) {
            if (minn > count) {
                minn = count;
            }
            return;
        }

        for (int i = 1; i <= 6; i++) {
            if (now + next <= 100) {
                if (arr[now + next] != 0 && !visited[arr[now + next]]) {
                    visited[arr[now+next]] = true;
                    value[arr[now+next]] = count + 1;
                    recursive(arr[now + next], i, count+1);
                    count -= 1;
                    visited[arr[now+next]] = false;
                } else {
                    visited[now + next] = true;
                    value[now + next] = count + 1;
                    recursive(now + next, i, count+1);
                    count -= 1;
                    visited[now + next] = false;
                }
            } else {
                return;
            }
        }
    }
}
