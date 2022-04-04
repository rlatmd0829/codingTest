package N_2022.April;

import java.util.Scanner;

public class boj_10971 {
    static int[][] arr;
    static int N;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            visited[i] = true;
            dfs(i,i,0,0);
        }
        System.out.println(result);
    }

    public static void dfs(int start, int now, int cost, int cnt) {
        if (cnt == N-1) {
            if (arr[now][start] != 0) {
                cost += arr[now][start];
                if (result > cost) {
                    result = cost;
                }
                return;
            }
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i] && arr[now][i] != 0) {
                visited[i] = true;
                dfs(start, i, cost+arr[now][i], cnt+1);
                visited[i] = false;
            }
        }
    }


}
