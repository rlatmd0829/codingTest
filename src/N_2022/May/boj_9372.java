package N_2022.May;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_9372 {
    static int N;
    static int M;
    static int[][] arr;
    static boolean[] visited;
    static int minn;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            minn = Integer.MAX_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[N+1][N+1];
            visited = new boolean[N+1];
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a][b] = arr[b][a] = 1;
            }

            System.out.println(bfs());
        }
    }

    private static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            Integer temp = queue.remove();
            for (int i = 1; i <= N; i++) {
                if (temp == i) {
                    continue;
                }
                if (arr[temp][i] == 1 && !visited[i]) {
                    count++;
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        return count;
    }
}
