package N_2021.November;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class boj_14502_연구소 {
    static int N;
    static int M;
    static int[][] map;
    static int[][] copy_map;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int result = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        copy_map = map;
        dfs(0);
        System.out.println(result);
    }

    // 벽세우기
    public static void dfs(int depth){
        if (depth == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 빈칸이라면
                if (map[i][j] == 0) {
                    // 벽 세우고
                    map[i][j] = 1;
                    dfs(depth + 1);
                    // 다시 돌려놓고
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void bfs() {
        int[][] virus_map = new int[N][M];
        Queue<virus> que = new LinkedList<>();

        // virus map 카피
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                virus_map[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 바이러스라면 큐에 넣어
                if (virus_map[i][j] == 2) {
                    que.add(new virus(i, j));
                }
            }
        }

        while (!que.isEmpty()){
            virus v = que.remove();

            for (int i = 0; i < 4; i++) {
                int nx = v.x + dx[i];
                int ny = v.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    // 빈칸이라면 바이러스 퍼뜨리고 다시 큐에 넣는다.
                    if (virus_map[nx][ny] == 0){
                        virus_map[nx][ny] = 2;
                        que.add(new virus(nx, ny));
                    }
                }
            }
        }
        safe(virus_map);
    }
    public static void safe(int[][] virus_map) {
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (virus_map[i][j] == 0) {
                    count++;
                }
            }
        }
        result = Math.max(count, result);
    }

    static class virus {
        int x;
        int y;
        virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}


