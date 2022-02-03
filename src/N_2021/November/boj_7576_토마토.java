package N_2021.November;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class tomato {
    int x; // 세로
    int y; // 가로

    tomato(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class boj_7576_토마토 {
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static int[][] map;
    public static Queue<tomato> que;
    public static int M; // 가로
    public static int N; // 세로

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();

        map = new int[N][M];

        que = new LinkedList<tomato>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1)
                    que.add(new tomato(i,j));

            }
        }
        System.out.println(BFS());
    }
    public static int BFS(){
        while (!que.isEmpty()) {
            tomato t = que.remove();

            int x = t.x;
            int y = t.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M){
                    if (map[nx][ny] == 0){
                        que.add(new tomato(nx, ny));
                        map[nx][ny] = map[x][y] + 1;
                    }
                }
            }
        }
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    return -1;
                }
                result = Math.max(result, map[i][j]);
            }
        }

        if (result == 1)
            return 0;
        else
            return result-1;
    }
}
