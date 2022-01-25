package past.November;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_1012_유기농배추 {
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N;
    static int M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int count = 0;
            M = sc.nextInt();
            N = sc.nextInt();
            int K = sc.nextInt();

            arr = new int[M][N];
            visited = new boolean[M][N];

            for (int j = 0; j < K; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                arr[a][b] = 1;
            }

            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (arr[j][k] == 1 && !visited[j][k]){
                        bfs(j, k);
                        count++;
                    }
                }
            }
            System.out.println(count);

        }


    }
    static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y});
        visited[x][y] = true;

        while (!queue.isEmpty()){
            int[] q = queue.poll();
            int qx = q[0];
            int qy = q[1];

            for (int i = 0; i < 4; i++) {
                int nx = qx + dx[i];
                int ny = qy + dy[i];

                if (nx < 0 || ny < 0 || nx >= M || ny >= N)
                    continue;
                if (arr[nx][ny] == 0 || visited[nx][ny])
                    continue;

                queue.add(new int[] {nx,ny});
                visited[nx][ny] = true;
            }
        }
    }
}
