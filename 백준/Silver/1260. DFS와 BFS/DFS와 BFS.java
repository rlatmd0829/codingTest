

import java.util.*;

public class Main {
    static int N;
    static int M;
    static int V;
    static int[][] arr;
    static boolean[] visited;
    static List<Integer> bfsResult;
    static List<Integer> dfsResult;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        arr = new int[N+1][N+1];
        visited = new boolean[N+1];
        dfsResult = new ArrayList<>();
        bfsResult = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = arr[b][a] = 1;
        }
        dfsResult.add(V);
        dfs(V);
        for (int i = 0; i < dfsResult.size(); i++) {
            System.out.print(dfsResult.get(i) + " ");
        }
//        System.out.println(dfsResult);

        visited = new boolean[N+1];
        System.out.println();

        bfsResult.add(V);
        bfs(V);
        for (int i = 0; i < bfsResult.size(); i++) {
            System.out.print(bfsResult.get(i) + " ");
        }
//        System.out.println(bfsResult);



    }
    public static void bfs(int V) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        visited[V] = true;
        while (!queue.isEmpty()) {
            int now = queue.remove();
            for (int i = 1; i <= N; i++) {
                if (arr[now][i] == 1) {
                    if (!visited[i]) {
                        queue.add(i);
                        visited[i] = true;
                        bfsResult.add(i);
                    }
                }
            }
        }
    }

    public static void dfs(int V) {
        visited[V] = true;

        for (int i = 1; i <= N; i++) {
            if (arr[V][i] == 1) {
                if (!visited[i]) {
                    dfsResult.add(i);
                    dfs(i);
                    visited[i] = true;
                }
            }
        }
    }
}
